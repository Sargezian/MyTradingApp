package com.example.mytradingapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mytradingapp.DAO.StockDao;
import com.example.mytradingapp.DAO.StockUserDatabase;
import com.example.mytradingapp.Shared.Entity.User;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {

    private final Application app;
    private static UserRepository instance;
    private final ExecutorService executorService;
    private final StockDao stockDao;

    private UserRepository(Application app) {
        this.app = app;
        StockUserDatabase database = StockUserDatabase.getInstance(app);
        stockDao = database.stockDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized UserRepository getInstance(Application app) {
        if(instance == null)
            instance = new UserRepository(app);
        return instance;
    }



    public void signOut() {
        AuthUI.getInstance()
                .signOut(app.getApplicationContext());
    }

    public void insert(User user) {
        executorService.execute(() -> stockDao.addUser(user));
    }

}
