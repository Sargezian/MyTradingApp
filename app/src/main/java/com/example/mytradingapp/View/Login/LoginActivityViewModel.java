package com.example.mytradingapp.View.Login;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.View.Main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivityViewModel extends ViewModel {

    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    public LiveData<String> getMessage () {
        return message;

    }

    public LiveData<Boolean> isLoading() {
        return isLoading;
    }

    public void retrieveData() {
        isLoading.setValue(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                message.postValue("Succes");
                isLoading.postValue(false);
            }
        }, 3000);
    }

}
