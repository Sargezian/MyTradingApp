package com.example.mytradingapp.View.FireBaseSignUp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mytradingapp.Repository.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public SignInViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

//    public LiveData<FirebaseUser> getCurrentUser(){
//        return userRepository.getCurrentUser();
//    }
}
