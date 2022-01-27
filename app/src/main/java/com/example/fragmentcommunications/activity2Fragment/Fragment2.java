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

public class Fragment2 extends Fragment implements MyDialogFragment.MyDialogFragmentListener{

    private static final String TAG = "Fragment2";

    private Fragment2Listener fragment2Listener;
    EditText editText1;
    Button send1Button;
    TextView textView1;

    @Override
    public void sendInput(String input) {
        fragment2Listener.onInput2Sent(input);
    }

    public interface Fragment2Listener {
        void onInput2Sent(String input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText1 = getActivity().findViewById(R.id.editText2);
        send1Button = getActivity().findViewById(R.id.button2);
        textView1 = getActivity().findViewById(R.id.textView2);

        send1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = String.valueOf(editText1.getText());
                MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(input);
                myDialogFragment.setTargetFragment(Fragment2.this, 1);
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
        if(context instanceof Fragment2Listener){
            fragment2Listener = (Fragment2Listener) context;
        }
        else{
            //exception
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragment2Listener = null;
    }
}
