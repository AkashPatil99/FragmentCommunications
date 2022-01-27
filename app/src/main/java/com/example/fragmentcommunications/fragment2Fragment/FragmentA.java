package com.example.fragmentcommunications.fragment2Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentcommunications.R;

public class FragmentA extends Fragment implements com.example.fragmentcommunications.fragment2Fragment.MyDialogFragment.MyDialogFragmentListener {

    private static final String TAG = "FragmentA";
    private static String ARG_STRING = "arg_string";

    private FragmentAListener fragmentAListener;
    EditText editText1;
    Button send1Button;
    TextView textView1;
    String input;

    public static FragmentA newInstance(String string) {
        FragmentA fragmentA = new FragmentA();
        Log.d(TAG, "newInstance:N "+string);
        Bundle arguments = new Bundle(1);
        arguments.putString(ARG_STRING,string);
        fragmentA.setArguments(arguments);

        return fragmentA;
    }

    @Override
    public void updateEditText() {
        editText1.setText(null);
    }

    @Override
    public void updateTextView() {
        textView1.setText(input);
    }

    public interface FragmentAListener {
        void onInput1Sent(String input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText1 = getActivity().findViewById(R.id.editText1);
        send1Button = getActivity().findViewById(R.id.button1);
        textView1 = getActivity().findViewById(R.id.textView1);

        view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));

        Bundle arguments = getArguments();
        if (arguments != null) {
            textView1.setText(arguments.getString(ARG_STRING));
        }

        send1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = String.valueOf(editText1.getText());
                MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(input);
                myDialogFragment.setTargetFragment(FragmentA.this, 1);
                myDialogFragment.show(getFragmentManager(),"MyDialogFragment");
            }
        });

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            fragmentAListener = (FragmentAListener) context;
        }
        else{
            //exception
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentAListener = null;
    }
}
