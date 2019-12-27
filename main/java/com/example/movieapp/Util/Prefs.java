package com.example.movieapp.Util;

import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Prefs {
    SharedPreferences sharedPreferences;

    public Prefs(Activity activity) {
        sharedPreferences = activity.getPreferences(MODE_PRIVATE);
    }

    public void setSearch(String search) {
        sharedPreferences.edit().putString("search", search).apply();
    }

    public String getSearch() {
        return sharedPreferences.getString("search", "Batman");
    }
}
