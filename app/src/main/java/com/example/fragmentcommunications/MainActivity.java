package com.example.fragmentcommunications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void activity2Fragment(View view) {
        Toast.makeText(this, "Starting Activity to Fragment communication", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, com.example.fragmentcommunications.activity2Fragment.ParentActivity.class));
    }

    public void fragment2Fragment(View view) {
        Toast.makeText(this, "Starting Fragment to Fragment communication", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, com.example.fragmentcommunications.fragment2Fragment.BaseActivity.class));
    }
}