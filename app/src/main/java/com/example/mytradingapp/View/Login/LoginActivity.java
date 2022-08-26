package com.example.mytradingapp.View.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProvider;


import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Entity.User;
import com.example.mytradingapp.View.Main.MainActivity;
import com.example.mytradingapp.View.SignUp.SignUpActivity;
import com.example.mytradingapp.View.SignUp.SignUpActivityViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class LoginActivity extends AppCompatActivity {


    private SignInButton signInButton;
    private GoogleSignInClient signInClient;
    private static final int RC_SIGN_IN = 9999;
    private FirebaseAuth firebaseAuth;
    private Button signUp;
    private Button btn_login;
    private AppCompatEditText et_email;
    private AppCompatEditText et_password;
    private SignUpActivityViewModel signUpActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInButton = findViewById(R.id.google_sign_in);
        signUp = findViewById(R.id.btn_sign_up);
        btn_login = findViewById(R.id.btn_login);
        et_email = findViewById(R.id.et_username_sign_in);
        et_password = findViewById(R.id.et_password_sign_in);
        signUpActivityViewModel = new ViewModelProvider(this).get(SignUpActivityViewModel.class);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        signInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        firebaseAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(this::signInWithGoogle);

        signUp.setOnClickListener(this::signUp);

        btn_login.setOnClickListener(this::signIn);





    }


    private void signUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    private void signInWithGoogle(View view) {

        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount googleSignInAccount = accountTask.getResult(ApiException.class);
                handleSignInResult(googleSignInAccount);


            } catch (Exception e) {
                Log.w("LoginActivity", "Google sign in failed", e);

            }
        }


    }

    private void handleSignInResult(GoogleSignInAccount googleSignInAccount) {
        AuthCredential credential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                User user1 = new User(authResult.getUser().getUid(),authResult.getUser().getDisplayName(), authResult.getUser().getEmail());
                signUpActivityViewModel.addSUser(user1);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void signIn(View view) {
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (email.isEmpty()){
            et_email.setError("email can not be empty");
            et_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Email must be valid");
            et_email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            et_password.setError("password can not be empty");
            et_password.requestFocus();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()){
                        signUpActivityViewModel.addSUser(new User(user.getUid(),user.getEmail(), user.getEmail()));

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();

                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this,"Check email to verify account",Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(LoginActivity.this,"Failed to Login",Toast.LENGTH_LONG).show();
                }
            }
        });


        et_email.setText("");
        et_password.setText("");

    }








}
