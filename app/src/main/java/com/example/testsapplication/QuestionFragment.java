package com.example.testsapplication;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.testsapplication.model.Answer;
import com.example.testsapplication.model.Question;
import com.example.testsapplication.testmanager.TestManager;

import java.util.List;


public class QuestionFragment extends Fragment {

    private Button answer_button;
    private Button skip_button;

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.fragment_question, container, false);
        answer_button = returnView.findViewById(R.id.answer_button);
        skip_button = returnView.findViewById(R.id.answer_button);
        TextView tv_question_body = returnView.findViewById(R.id.question_body);
        TextView tv_question_number = returnView.findViewById(R.id.question_number);
        RadioGroup radioGroup = (RadioGroup) returnView.findViewById(R.id.answers_radio_group);

        /* General comment regarding this Fragment
        *  We should detect what radio button is checked to figure out what answer was provided
        */

        Question curr_question = TestManager.getInstance().getCurrentExam().getCurrentQuestion();
        tv_question_body.setText(curr_question.getBody());
        tv_question_number.setText(String.valueOf(TestManager.getInstance().getCurrentExam().getPosition()+1)+"/10");
        List<Answer> answer_list = curr_question.getAnswers();
        for(Answer answer:answer_list) {
            RadioButton rdbtn = new RadioButton(getContext());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(answer.getAnsBody());
            radioGroup.addView(rdbtn);
        }

       answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TestManager.getInstance().getCurrentExam().answerQuestion(5);
            }
        });
        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestManager.getInstance().getCurrentExam().skipQuestion();
            }
        });

        return returnView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
