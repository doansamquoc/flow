package com.sam.friendlens.ui.auth.login;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

import com.sam.friendlens.ui.auth.data.repository.AuthRepository;

public class LoginViewModel extends ViewModel {
    private AuthRepository authRepository;

    public LoginViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void signInWithGoogle(Activity activity) {
        authRepository.launchCredentialManager(activity);
    }
}
