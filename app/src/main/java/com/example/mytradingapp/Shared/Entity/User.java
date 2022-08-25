package com.example.mytradingapp.Shared.Entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.mytradingapp.Shared.Transferobjects.Stock;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey()
    @NonNull
    private String id;
    private String name;
    private String email;


    public User() {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


   @Ignore
    public User(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}


