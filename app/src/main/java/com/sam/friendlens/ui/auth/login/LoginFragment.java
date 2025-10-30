package com.sam.friendlens.ui.auth.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.friendlens.R;
import com.sam.friendlens.databinding.FragmentLoginBinding;
import com.sam.friendlens.ui.auth.data.repository.AuthRepository;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private AuthRepository authRepository;
    private LoginViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        authRepository = AuthRepository.getInstance(requireContext());
        LoginViewModelFactory factory = new LoginViewModelFactory(authRepository);
        viewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        binding.continueWithGoogleButton.setOnClickListener(v ->
                viewModel.signInWithGoogle(requireActivity())
        );
    }

}