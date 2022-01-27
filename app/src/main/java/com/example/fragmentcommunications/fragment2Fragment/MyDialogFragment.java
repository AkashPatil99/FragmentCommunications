package com.example.fragmentcommunications.fragment2Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.fragmentcommunications.R;


public class MyDialogFragment extends DialogFragment{

    private static final String TAG = "MyDialogFragment";

    private Button sendButton,cancelButton;
    private TextView textView;
    MyDialogFragmentListener myDialogFragmentListener;
    String input;

    private static String ARG_STRING = "arg_string";

    public static MyDialogFragment newInstance(String string) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Log.d(TAG, "newInstance:N "+string);
        Bundle arguments = new Bundle(1);
        arguments.putString(ARG_STRING,string);
        myDialogFragment.setArguments(arguments);

        return myDialogFragment;
    }

    public interface MyDialogFragmentListener{
        void updateEditText();
        void updateTextView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mydialogfragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.dialog_text);
        sendButton = view.findViewById(R.id.send_button);
        cancelButton = view.findViewById(R.id.cancel_button);

        Bundle arguments = getArguments();
        if (arguments != null) {
            input = arguments.getString(ARG_STRING);
            Log.d(TAG, "newInstance:B "+input);
            textView.setText(input);
        }

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editText cleared
                myDialogFragmentListener.updateEditText();
                getDialog().dismiss();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send message
                Log.d(TAG, "newInstance:send "+input);
                myDialogFragmentListener.updateTextView();
                getDialog().dismiss();
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            myDialogFragmentListener = (MyDialogFragmentListener) getTargetFragment();
        }
        catch (ClassCastException e){
            Log.e(TAG, "onAttach: exception "+ e.getMessage());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myDialogFragmentListener = null;
    }
}
