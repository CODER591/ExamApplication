package com.example.testsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView=inflater.inflate(R.layout.fragment_question, container, false);
        RadioGroup radioGroup = (RadioGroup) returnView.findViewById(R.id.groupradio);
       /*
        //amount of answers
        for (int i = 1; i <= ; i++) {
            RadioButton rdbtn = new RadioButton(getContext());
            //rdbtn.setId(View.generateViewId());  ?? maybe wrap it inside of the API version check
            rdbtn.setText("");
            radioGroup.addView(rdbtn);
        }*/

        return returnView;
    }
}
