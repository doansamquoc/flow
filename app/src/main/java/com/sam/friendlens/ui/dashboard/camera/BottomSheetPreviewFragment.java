package com.sam.friendlens.ui.dashboard.camera;

import android.app.Dialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.sam.friendlens.R;
import com.sam.friendlens.databinding.FragmentBottomSheetPrewViewBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;


public class BottomSheetPreviewFragment extends BottomSheetDialogFragment {
    private static final String ARG_IMAGE_PATH = "image_path";
    private String getArgImagePath;
    private FragmentBottomSheetPrewViewBinding binding;

    public static BottomSheetPreviewFragment newInstance(String imagePath) {
        BottomSheetPreviewFragment fragment = new BottomSheetPreviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE_PATH, imagePath);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArgImagePath = getArguments().getString(ARG_IMAGE_PATH);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBottomSheetPrewViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView imageView = binding.imagePreview;
        MaterialButton saveButton = binding.saveButton;
        MaterialButton submitButton = binding.submitButton;
        MaterialButton cancelButton = binding.cancelButton;

        imageView.setImageURI(Uri.fromFile(new File(getArgImagePath)));

        saveButton.setOnClickListener(v -> saveImageToGallery(getArgImagePath));
        cancelButton.setOnClickListener(v -> this.dismiss());
    }

    @Override
    public void onStart() {
        super.onStart();
        BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
        if (dialog != null) {
            FrameLayout bottomSheet = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                ViewGroup.LayoutParams params = bottomSheet.getLayoutParams();
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                bottomSheet.setLayoutParams(params);

                BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                behavior.setSkipCollapsed(true);
            }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(
                requireContext(),
                com.google.android.material.R.style.Base_V14_ThemeOverlay_Material3_BottomSheetDialog
        );

        Window window = dialog.getWindow();
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, false);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }

        dialog.setOnShowListener(d -> {
            FrameLayout sheet = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (sheet != null) {
                sheet.setFitsSystemWindows(false);
                ViewCompat.setOnApplyWindowInsetsListener(sheet, (v, insets) -> insets);
            }
        });

        return dialog;
    }

    private void saveImageToGallery(String imagePath) {
        File file = new File(imagePath);
        if (!file.exists()) return;

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + R.string.app_name);

        Uri uri = requireContext().getContentResolver()
                .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try {
            assert uri != null;
            try (OutputStream out = requireContext().getContentResolver().openOutputStream(uri);
                 FileInputStream in = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    assert out != null;
                    out.write(buffer, 0, len);
                }
                Toast.makeText(requireContext(), "Saved image to library", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Log.e("CAMERA", Objects.requireNonNull(e.getLocalizedMessage()));
            Toast.makeText(requireContext(), "Save image failed", Toast.LENGTH_SHORT).show();
        }
    }
}