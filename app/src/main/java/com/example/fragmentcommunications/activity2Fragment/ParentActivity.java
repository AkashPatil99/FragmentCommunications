package com.example.fragmentcommunications.activity2Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentcommunications.R;

public class ParentActivity extends AppCompatActivity implements Fragment1.Fragment1Listener,Fragment2.Fragment2Listener {
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, fragment1)
                .replace(R.id.container2, fragment2)
                .commit();
    }

    @Override
    public void onInput1Sent(String input) {
        fragment2.updateTextView(input);
    }

    @Override
    public void onInput2Sent(String input) {
        fragment1.updateTextView(input);
    }

}