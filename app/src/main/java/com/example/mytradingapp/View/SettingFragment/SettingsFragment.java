package com.example.mytradingapp.View.SettingFragment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Main.MainActivityViewModel;
import com.example.mytradingapp.View.ReportApp.ReportFragment;

public class SettingsFragment extends PreferenceFragmentCompat {

    private MainActivityViewModel userviewModel;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        PreferenceCategory help_categoryPreference = findPreference("help_category");

        help_categoryPreference.setOnPreferenceClickListener(this::onClickReport);

/*        Preference signOutPreference = findPreference("login");

        signOutPreference.setOnPreferenceClickListener(this::signOut);*/

    }

    /*private boolean signOut(Preference preference) {
        userviewModel.signOut();
        return true;
    }*/



    private boolean onClickReport(Preference preference) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.nav_host_fragment, new ReportFragment());
        fr.commit();
        return true;
    }



}