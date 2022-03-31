package com.example.mytradingapp.View.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Login.LoginActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button button = findViewById(R.id.buttonBack);

        button.setOnClickListener(this::Back);
    }


    public void Back(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void Create(View view) {



    }

}