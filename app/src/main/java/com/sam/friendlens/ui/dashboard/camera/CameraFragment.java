package com.sam.friendlens.ui.dashboard.camera;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.core.TorchState;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.common.util.concurrent.ListenableFuture;
import com.sam.friendlens.R;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CameraFragment extends Fragment {

    private final ExecutorService cameraExecutor = Executors.newSingleThreadExecutor();
    private PreviewView previewView;
    private MaterialButton toggleFlash, flipCamera;
    private MaterialButton capture;
    private int cameraFacing = CameraSelector.LENS_FACING_BACK;
    private ImageCapture imageCapture;
    private ProcessCameraProvider cameraProvider;
    private final ActivityResultLauncher<String> permissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestPermission(),
                    result -> {
                        if (result) startCamera(cameraFacing);
                        else
                            Toast.makeText(requireContext(), "Camera permission denied", Toast.LENGTH_SHORT).show();
                    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        previewView = view.findViewById(R.id.preview_view);
        capture = view.findViewById(R.id.capture_button);
        toggleFlash = view.findViewById(R.id.flash_button);
        flipCamera = view.findViewById(R.id.flip_camera_button);

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            permissionLauncher.launch(Manifest.permission.CAMERA);
        } else {
            startCamera(cameraFacing);
        }

        flipCamera.setOnClickListener(v -> {
            cameraFacing = (cameraFacing == CameraSelector.LENS_FACING_BACK)
                    ? CameraSelector.LENS_FACING_FRONT
                    : CameraSelector.LENS_FACING_BACK;
            startCamera(cameraFacing);
        });

        return view;
    }

    private void startCamera(int lensFacing) {
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture =
                ProcessCameraProvider.getInstance(requireContext());

        cameraProviderFuture.addListener(() -> {
            try {
                cameraProvider = cameraProviderFuture.get();
                cameraProvider.unbindAll();

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(lensFacing)
                        .build();

                Preview preview = new Preview.Builder()
                        .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                        .build();

                imageCapture = new ImageCapture.Builder()
                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                        .setTargetRotation(requireActivity()
                                .getWindowManager()
                                .getDefaultDisplay()
                                .getRotation())
                        .setJpegQuality(100)
                        .build();

                Camera camera = cameraProvider.bindToLifecycle(
                        this,
                        cameraSelector,
                        preview,
                        imageCapture
                );

                preview.setSurfaceProvider(previewView.getSurfaceProvider());

                capture.setOnClickListener(v -> takePicture());
                toggleFlash.setOnClickListener(v -> toggleFlash(camera));

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    private void takePicture() {
        if (imageCapture == null) return;

//        ContentValues contentValues = new ContentValues();
//        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
//        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
//        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/MyAppPhotos");
//
//        ImageCapture.OutputFileOptions options =
//                new ImageCapture.OutputFileOptions.Builder(
//                        requireContext().getContentResolver(),
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                        contentValues
//                ).build();
        File tempFile = new File(requireContext().getCacheDir(), System.currentTimeMillis() + ".jpg");
        ImageCapture.OutputFileOptions options =
                new ImageCapture.OutputFileOptions.Builder(tempFile).build();

        imageCapture.takePicture(options, cameraExecutor, new ImageCapture.OnImageSavedCallback() {
            @Override
            public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                requireActivity().runOnUiThread(() -> {
                    BottomSheetPreviewFragment.newInstance(tempFile.getAbsolutePath()).show(
                            getParentFragmentManager(),
                            "preview_bottom_sheet"
                    );
                });
            }

            @Override
            public void onError(@NonNull ImageCaptureException exception) {
                Log.e("CameraX", "Capture failed", exception);
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(),
                                "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show());
            }
        });
    }


    private void toggleFlash(Camera camera) {
        if (!camera.getCameraInfo().hasFlashUnit()) {
            Toast.makeText(requireContext(), "No flash available", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer torchState = camera.getCameraInfo().getTorchState().getValue();
        boolean enable = (torchState == null || torchState == TorchState.OFF);

        camera.getCameraControl().enableTorch(enable);
        toggleFlash.setIcon(ContextCompat.getDrawable(
                requireContext(),
                enable ? R.drawable.flash_on : R.drawable.flash_off
        ));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (cameraProvider != null) {
            requireActivity().runOnUiThread(() -> cameraProvider.unbindAll());
        }

        if (cameraExecutor != null) {
            cameraExecutor.shutdown();
        }
    }
}
