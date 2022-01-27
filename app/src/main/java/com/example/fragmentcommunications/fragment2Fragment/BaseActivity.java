package com.example.fragmentcommunications.fragment2Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentcommunications.R;

public class BaseActivity extends AppCompatActivity {

    private BaseFragment baseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        baseFragment = new BaseFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_container, baseFragment).commit();
    }
}