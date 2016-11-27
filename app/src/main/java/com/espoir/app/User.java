package com.espoir.app;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class User {

    public String username;
    public String adresse;
    public String email;
    public String mp;


    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String emailS, String mpS) {
        emailS=email;
        mpS=mp;
    }

    public String getUsername() {
        return username;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getMp() {
        return mp;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("mp", mp);

        return result;
    }
}

