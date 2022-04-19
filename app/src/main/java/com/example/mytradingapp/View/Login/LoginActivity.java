package com.example.mytradingapp.View.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Main.MainActivity;
import com.example.mytradingapp.View.SignUp.SignUpActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    LoginActivityViewModel viewModel;
    TextView loginText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        loginText = findViewById(R.id.LoginText);
        progressBar = findViewById(R.id.progressBar);
        TextView textView = findViewById(R.id.SignUp);
        Button button = findViewById(R.id.buttonid);

        textView.setOnClickListener(this::Signup);
        button.setOnClickListener(this::retrieveDataFromInternet);

        viewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);
        viewModel.getMessage().observe(this, message -> loginText.setText(message));

        viewModel.isLoading().observe(this, isLoading -> {
            int visibility = isLoading ? View.VISIBLE : View.INVISIBLE;
            progressBar.setVisibility(visibility);

        });

    }


    public void retrieveDataFromInternet(View v) {
        viewModel.retrieveData();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        }, 5000);

    }

    public void Signup(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
