package com.example.mytradingapp.View.SettingFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Login.LoginActivity;
import com.example.mytradingapp.View.Main.MainActivityViewModel;
import com.example.mytradingapp.View.ReportApp.ReportFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsFragment extends PreferenceFragmentCompat {

    private MainActivityViewModel userviewModel;

    private FirebaseAuth firebaseAuth;
    private MainActivityViewModel viewModel;

    private GoogleSignInClient signInClient;

 //
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        PreferenceCategory help_categoryPreference = findPreference("help_category");

        help_categoryPreference.setOnPreferenceClickListener(this::onClickReport);


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();


        EditTextPreference emailPreference = findPreference("email");

        if (firebaseUser != null) {
            emailPreference.setText(firebaseUser.getEmail());

        }

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        signInClient = GoogleSignIn.getClient(getContext(), googleSignInOptions);

        Preference signOutPreference = findPreference("signout");

        signOutPreference.setOnPreferenceClickListener(this::signOut);

    }



    private boolean signOut(Preference preference) {

        firebaseAuth.signOut();
        signInClient.signOut();
        startActivity(new Intent(getContext(), LoginActivity.class));
        getActivity().finish();
        return true;
    }




    private boolean onClickReport(Preference preference) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.nav_host_fragment, new ReportFragment());
        fr.commit();
        return true;
    }


}