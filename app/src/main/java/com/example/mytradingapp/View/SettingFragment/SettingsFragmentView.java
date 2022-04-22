package com.example.mytradingapp.View.SettingFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.preference.PreferenceFragmentCompat;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Login.LoginActivity;

public class SettingsFragmentView extends PreferenceFragmentCompat {



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);


    }



}