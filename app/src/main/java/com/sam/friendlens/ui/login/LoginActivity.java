//package com.sam.friendlens.ui.login;
//
//import static com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.os.CancellationSignal;
//import android.util.Log;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.credentials.ClearCredentialStateRequest;
//import androidx.credentials.Credential;
//import androidx.credentials.CredentialManager;
//import androidx.credentials.CredentialManagerCallback;
//import androidx.credentials.CustomCredential;
//import androidx.credentials.GetCredentialRequest;
//import androidx.credentials.GetCredentialResponse;
//import androidx.credentials.exceptions.ClearCredentialException;
//import androidx.credentials.exceptions.GetCredentialException;
//
//import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
//import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.GoogleAuthProvider;
//import com.sam.friendlens.R;
//
//import java.util.Objects;
//import java.util.concurrent.Executors;
//
//
//public class LoginActivity extends AppCompatActivity {
//    private static final String TAG = "GoogleActivity";
//    private FirebaseAuth mAuth;
//    private CredentialManager credentialManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_login);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        mAuth = FirebaseAuth.getInstance();
//        credentialManager = CredentialManager.create(this);
//
//        findViewById(R.id.continue_with_google_button).setOnClickListener(v -> launchCredentialManager());
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void useFrameworkCredentialManager() {
//        GetGoogleIdOption googleIdOption = new GetGoogleIdOption.Builder()
//                .setFilterByAuthorizedAccounts(false)
//                .setServerClientId(getString(R.string.default_web_client_id))
//                .build();
//
//        GetCredentialRequest request = new GetCredentialRequest.Builder()
//                .addCredentialOption(googleIdOption)
//                .build();
//
//        credentialManager.getCredentialAsync(
//                this,
//                request,
//                new CancellationSignal(),
//                Executors.newSingleThreadExecutor(),
//                new CredentialManagerCallback<>() {
//                    @Override
//                    public void onResult(GetCredentialResponse result) {
//                        handleSignIn(result.getCredential());
//                    }
//
//                    @Override
//                    public void onError(@NonNull GetCredentialException e) {
//                        Log.e(TAG, Objects.requireNonNull(e.getLocalizedMessage()));
//                    }
//                }
//        );
//    }
//
//    private void useAndroidXCredentialManager() {
//        androidx.credentials.CredentialManager credentialManager =
//                androidx.credentials.CredentialManager.create(this);
//
//        GetGoogleIdOption googleIdOption = new GetGoogleIdOption.Builder()
//                .setFilterByAuthorizedAccounts(false)
//                .setServerClientId(getString(R.string.default_web_client_id))
//                .build();
//
//        androidx.credentials.GetCredentialRequest request =
//                new androidx.credentials.GetCredentialRequest.Builder()
//                        .addCredentialOption(googleIdOption)
//                        .build();
//
//        credentialManager.getCredentialAsync(
//                this,
//                request,
//                new CancellationSignal(),
//                Executors.newSingleThreadExecutor(),
//                new androidx.credentials.CredentialManagerCallback<>() {
//
//                    @Override
//                    public void onResult(androidx.credentials.GetCredentialResponse result) {
//                        handleSignIn(result.getCredential());
//                    }
//
//                    @Override
//                    public void onError(
//                            @NonNull androidx.credentials.exceptions.GetCredentialException e) {
//                        Log.e(TAG, Objects.requireNonNull(e.getLocalizedMessage()));
//                    }
//                }
//        );
//    }
//
//    private void launchCredentialManager() {
//        if (Build.VERSION.SDK_INT >= 34) {
//            useFrameworkCredentialManager();
//        } else {
//            useAndroidXCredentialManager();
//        }
//    }
//
//    private void handleSignIn(Credential credential) {
//        if (credential instanceof CustomCredential
//                && credential.getType().equals(TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
//            CustomCredential customCredential = (CustomCredential) credential;
//            Bundle credentialData = customCredential.getData();
//            GoogleIdTokenCredential googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credentialData);
//            firebaseAuthWithGoogle(googleIdTokenCredential.getIdToken());
//        } else {
//            Log.w(TAG, "Credential is not of type Google ID!");
//        }
//
//    }
//
//    private void firebaseAuthWithGoogle(String idToken) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, task -> {
//                    if (task.isSuccessful()) {
//                        Log.d(TAG, "signInWithCredential:success");
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        updateUI(user);
//                    } else {
//                        Log.w(TAG, "signInWithCredential:failure", task.getException());
//                        updateUI(null);
//                    }
//                });
//    }
//
//    private void signOut() {
//        mAuth.signOut();
//        ClearCredentialStateRequest clearRequest = new ClearCredentialStateRequest();
//        credentialManager.clearCredentialStateAsync(
//                clearRequest,
//                new CancellationSignal(),
//                Executors.newSingleThreadExecutor(),
//                new CredentialManagerCallback<Void, ClearCredentialException>() {
//                    @Override
//                    public void onResult(Void unused) {
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull ClearCredentialException e) {
//                        Log.e(TAG, "Couldn't clear user credentials: 2");
//                    }
//                });
//    }
//
//    private void updateUI(FirebaseUser user) {
//    }
//}
