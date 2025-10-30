package com.sam.friendlens.ui.auth.data.repository;

import static com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.GetCredentialException;

import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.sam.friendlens.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AuthRepository {
    private static final String TAG = "AuthRepository";
    private static volatile AuthRepository instance;
    private final FirebaseAuth firebaseAuth;
    private final CredentialManager credentialManager;

    private AuthRepository(Context context) {
        firebaseAuth = FirebaseAuth.getInstance();
        credentialManager = CredentialManager.create(context);
    }
    public static AuthRepository getInstance(Context context) {
        if (instance == null) {
            synchronized (AuthRepository.class) {
                if (instance == null) {
                    instance = new AuthRepository(context);
                }
            }
        }
        return instance;
    }

    public void launchCredentialManager(Activity activity) {
        if (Build.VERSION.SDK_INT >= 34) {
            useFrameworkCredentialManager(activity);
        } else {
            useAndroidXCredentialManager(activity);
        }
    }

    private void useFrameworkCredentialManager(Activity activity) {
        GetGoogleIdOption googleIdOption = new GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(activity.getString(R.string.default_web_client_id))
                .build();

        GetCredentialRequest request = new GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build();

        credentialManager.getCredentialAsync(
                activity,
                request,
                new CancellationSignal(),
                Executors.newSingleThreadExecutor(),
                new CredentialManagerCallback<>() {
                    @Override
                    public void onResult(GetCredentialResponse result) {
                        handleSignIn(result.getCredential());
                    }

                    @Override
                    public void onError(@NonNull GetCredentialException e) {
                        Log.e(TAG, Objects.requireNonNull(e.getLocalizedMessage()));
                    }
                }
        );
    }

    private void useAndroidXCredentialManager(Activity activity) {
        androidx.credentials.CredentialManager credentialManager =
                androidx.credentials.CredentialManager.create(activity);

        GetGoogleIdOption googleIdOption = new GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(activity.getString(R.string.default_web_client_id))
                .build();

        androidx.credentials.GetCredentialRequest request =
                new androidx.credentials.GetCredentialRequest.Builder()
                        .addCredentialOption(googleIdOption)
                        .build();

        credentialManager.getCredentialAsync(
                activity,
                request,
                new CancellationSignal(),
                Executors.newSingleThreadExecutor(),
                new androidx.credentials.CredentialManagerCallback<>() {

                    @Override
                    public void onResult(androidx.credentials.GetCredentialResponse result) {
                        handleSignIn(result.getCredential());
                    }

                    @Override
                    public void onError(
                            @NonNull androidx.credentials.exceptions.GetCredentialException e) {
                        Log.e(TAG, Objects.requireNonNull(e.getLocalizedMessage()));
                    }
                }
        );
    }

    private void handleSignIn(Credential credential) {
        if (credential instanceof CustomCredential customCredential
                && credential.getType().equals(TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
            Bundle credentialData = customCredential.getData();
            GoogleIdTokenCredential googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credentialData);
            firebaseAuthWithGoogle(googleIdTokenCredential.getIdToken());
        } else {
            Log.w(TAG, "Credential is not of type Google ID!");
        }

    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        updateUI(user);
                        assert user != null;
                        saveUserToFirestore(user);
                    } else {
                        updateUI(null);
                    }
                });

    }

    private void signOut() {
        firebaseAuth.signOut();
        credentialManager.clearCredentialStateAsync(
                new ClearCredentialStateRequest(),
                new CancellationSignal(),
                Executors.newSingleThreadExecutor(),
                new CredentialManagerCallback<>() {
                    @Override
                    public void onResult(Void unused) {

                    }

                    @Override
                    public void onError(@NonNull ClearCredentialException e) {
                        Log.e(TAG, "Couldn't clear user credentials: 2");
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
    }

    private void saveUserToFirestore(FirebaseUser user) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("uid", user.getUid());
        userMap.put("name", user.getDisplayName());
        userMap.put("email", user.getEmail());
        userMap.put("photoUrl", user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : null);
        userMap.put("createdAt", FieldValue.serverTimestamp());

        db.collection("users")
                .document(user.getUid())
                .set(userMap, SetOptions.merge())
                .addOnSuccessListener(aVoid -> Log.d("Firestore", "User saved"))
                .addOnFailureListener(e -> Log.e("Firestore", "Error saving user", e));
    }

}

