package com.example.mytradingapp.View.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class HomeFragment extends Fragment {

    private TextView email;
    private FirebaseAuth firebaseAuth;
    private GoogleSignInClient signInClient;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        email = view.findViewById(R.id.tv_email);
        button = view.findViewById(R.id.btn_sign_out);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            email.setText(firebaseUser.getEmail());

        }

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        signInClient = GoogleSignIn.getClient(getContext(), googleSignInOptions);

        button.setOnClickListener(this::signOut);

        return view;
    }

    private void signOut(View view) {

        firebaseAuth.signOut();
        signInClient.signOut();
        startActivity(new Intent(getContext(), LoginActivity.class));
        getActivity().finish();
    }


}