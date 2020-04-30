package com.example.testsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testsapplication.testmanager.TestManager;


public class FinishPageFragment extends Fragment {


    public FinishPageFragment() {
        // Required empty public constructor
    }

    public static FinishPageFragment newInstance(String param1, String param2) {
        FinishPageFragment fragment = new FinishPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_finish_page, container, false);
        TextView tv_right_ans = view.findViewById(R.id.right_answers);
        int all_qst_quantity = TestManager.getInstance().getCurrentExam().getExamQuestionsCount();
        int right_ans_quantity = TestManager.getInstance().getCurrentExam().getCorrectAnswers();
        tv_right_ans.setText(String.valueOf(right_ans_quantity)+"/"+String.valueOf(all_qst_quantity));
        
        return view;
    }
}
