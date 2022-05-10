package com.example.mytradingapp.View.FireBaseSignUp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Main.MainActivity;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private SignInViewModel viewModel;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK)
                    goToMainActivity();
                else
                    Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        checkIfSignedIn();
        signIn();
        /*    setContentView(R.layout.activity_sign_in);*/
    }

    private void checkIfSignedIn() {
//        viewModel.getCurrentUser().observe(this, user -> {
//            if (user != null)
//                goToMainActivity();
//        });
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void signIn() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_baseline_star_24)
                .setTheme(R.style.Theme_MyTradingApp)
                .build();

        activityResultLauncher.launch(signInIntent);
    }
}
