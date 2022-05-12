package com.example.mytradingapp.View.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mytradingapp.R;

import com.example.mytradingapp.View.FireBaseSignUp.SignInActivity;
import com.example.mytradingapp.View.Login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavController navController;
    BottomNavigationView bottomNavigationView;
    AppBarConfiguration appBarConfiguration;

    private MainActivityViewModel userviewModel;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bNav);

        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);


        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,
                R.id.newsFragment,R.id.searchFragment,R.id.marketFragment, R.id.usaFragment
                 )
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        userviewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        /*        userviewModel.init();*/

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }



    private void startLoginActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    public void signOut(View v) {
        userviewModel.signOut();
    }
}