package com.example.mytradingapp.View.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.util.Log;


import com.example.mytradingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.scichart.charting.visuals.SciChartSurface;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavController navController;
    BottomNavigationView bottomNavigationView;
    AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_view);

        try {
            SciChartSurface.setRuntimeLicenseKey("HuJVMMqIClc5Vuiud+gr9WOrBiMqyxy1vmGLsL8iu8q1560JRHZUN70oNc2wf+BaAiakYX7HfOzCqnOiz7/iEXnzikI8u4RVTX7fQPozNBJEQKIBNPgOcOfVRkz48OIyrPrvD+HLTn9rGkp4421j8X6dpbtDIqMlsUcCOW40dxXpsDoyRJIQEGWrxWAo86/3r1e2ccrCQoCqCe3cn3KM7qYrYeuxPLOLvzOOoJksruVybhnErO4Ee8ZRCftMyvtO73SpHB41gh+VTw7DCoIXZHf0H8L2r0YqJ+HZcaDKisPNqmECGDoVtOaALNLD3Xalsea9l3iIqsCXfqFUang2bXY44MnkeCG4LZCDVOFUEwlgKVKpyi/mS4c50o/ZN2mxl7ANPaVmGdgf8SjHbPrRxnOJDs1LeOiYpDaruocoo5FXviUAkhCm2aPtttFLA994HrSfD4vTOroyuI2v9JW17l9drQdYzRqNC6YrelQGMEguiLNSdZbqioYYPr7y/6OKTJ53bGpQ0X+b8w==");
        } catch (Exception e) {
            Log.e("SciChart", "Error when setting the license", e);
        }

/*
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bNav);

        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);


        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,
                R.id.newsFragment,R.id.searchFragment,R.id.marketFragment,R.id.settingsFragment
                 )
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
*/


    }

}