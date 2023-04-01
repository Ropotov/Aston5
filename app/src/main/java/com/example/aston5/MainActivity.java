package com.example.aston5;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements Navigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commit();
    }

    @Override
    public void NavigateToDetailFragment(String fistName, String lastName, String phone) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(fistName, lastName, phone))
                .addToBackStack(null)
                .commit();
    }
}