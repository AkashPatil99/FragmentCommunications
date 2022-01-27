package com.example.fragmentcommunications.fragment2Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentcommunications.R;
import com.example.fragmentcommunications.activity2Fragment.Fragment1;
import com.example.fragmentcommunications.activity2Fragment.Fragment2;

public class BaseFragment extends Fragment implements FragmentA.FragmentAListener,FragmentB.FragmentBListener{

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment1Container, fragmentA)
                .replace(R.id.fragment2Container, fragmentB)
                .commit();
    }

    @Override
    public void onInput1Sent(String input) {
        fragmentB.textView1.setText(input);
    }

    @Override
    public void onInput2Sent(String input) {
        fragmentA.textView1.setText(input);
    }
}
