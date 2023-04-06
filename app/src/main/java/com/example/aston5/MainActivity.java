package com.example.aston5;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

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
    public void NavigateToDetailFragment(ListItem listItem) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(listItem))
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containerDetail, DetailFragment.newInstance(listItem))
                    .commit();
        }
    }
}