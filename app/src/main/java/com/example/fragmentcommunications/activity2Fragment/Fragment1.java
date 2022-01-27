package com.example.fragmentcommunications.activity2Fragment;

import android.content.Context;
import android.os.Bundle;
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

public class Fragment1 extends Fragment implements MyDialogFragment.MyDialogFragmentListener{

    private static final String TAG = "Fragment1";

    private Fragment1Listener fragment1Listener;
    EditText editText1;
    Button send1Button;
    TextView textView1;

    @Override
    public void sendInput(String input) {
        fragment1Listener.onInput1Sent(input);
    }

    public interface Fragment1Listener {
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

        send1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = String.valueOf(editText1.getText());
                MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(input);
                myDialogFragment.setTargetFragment(Fragment1.this, 1);
                myDialogFragment.show(getFragmentManager(),"MyDialogFragment");
            }
        });

    }

    public void updateTextView(CharSequence newText) {
        textView1.setText(newText);
    }

    public void updateEditText() {
        editText1.setText(null);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragment1Listener){
            fragment1Listener = (Fragment1Listener) context;
        }
        else{
            //exception
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragment1Listener = null;
    }
}
