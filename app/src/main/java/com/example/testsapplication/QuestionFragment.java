package com.example.testsapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class QuestionFragment extends Fragment {

    private Button answer_button;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.fragment_question, container, false);
        RadioGroup radioGroup = (RadioGroup) returnView.findViewById(R.id.answers_radio_group);
        /* General comment regarding this Fragment
        *  On this fragment should appear as much radiobuttons as Question had answers
        *  We should detect what radio button is checked to figure out what answer was provided
        *
        * */

       /*
        //amount of answers
        for (int i = 1; i <= ; i++) {
            RadioButton rdbtn = new RadioButton(getContext());
            //rdbtn.setId(View.generateViewId());  ?? maybe wrap it inside of the API version check
            rdbtn.setText("");
            radioGroup.addView(rdbtn);
        }*/
       answer_button = returnView.findViewById(R.id.answer_button);
       answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return returnView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
