package com.example.mytradingapp.View.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Home.HomeFragment;
import com.example.mytradingapp.View.SignUp.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        TextView textView = findViewById(R.id.SignUp);
        Button button = findViewById(R.id.buttonid);

        textView.setOnClickListener(this::Signup);
        /*button.setOnClickListener(this::Login);*/


    }

    public void Signup(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


    /*public void Login(View v) {
        Intent intent = new Intent(this, HomeFragment.class);
        startActivity(intent);
    }*/

  /*  public void login(View view) {
        Toast.makeText(this, "Hi User", Toast.LENGTH_LONG).show();

        *//*textView.setText("Yeah");
        Log.i("test", "This is a message");*//*
    }*/


}
