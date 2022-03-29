package com.example.mytradingapp.View.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mytradingapp.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button button = findViewById(R.id.buttonid);

    }

    public void login(View view) {
        Toast.makeText(this, "Hi User", Toast.LENGTH_LONG).show();

        /*textView.setText("Yeah");
        Log.i("test", "This is a message");*/

    }


}
