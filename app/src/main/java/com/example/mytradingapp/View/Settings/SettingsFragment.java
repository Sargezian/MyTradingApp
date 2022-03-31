package com.example.mytradingapp.View.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Login.LoginActivity;


public class SettingsFragment extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        textView = view.findViewById(R.id.login);
        textView.setOnClickListener(this::onSend);

        // Inflate the layout for this fragment
        return view ;
    }


    public void onSend(View v) {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

}