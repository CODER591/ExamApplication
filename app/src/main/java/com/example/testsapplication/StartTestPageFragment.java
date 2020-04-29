package com.example.testsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.testsapplication.testmanager.TestManager;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartTestPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartTestPageFragment extends Fragment {


    public StartTestPageFragment() {
        // Required empty public constructor
    }

    public static StartTestPageFragment newInstance() {
        return new StartTestPageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_start_test_page, container, false);
        //looks like this below should be moved to other fragment
        final Button start_btn = view.findViewById(R.id.test_start_button);
        final TextView test_name_view = view.findViewById(R.id.test_name);
        final TextView test_description_view = view.findViewById(R.id.test_description);
        String testname = TestManager.getInstance().getCurrentExam().getName();
        String description = TestManager.getInstance().getCurrentExam().getDescription();
        test_name_view.setText(testname);
        test_description_view.setText(description);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // start test
                // start timer
                // go to fragment

                Fragment questionFragment = new QuestionFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, questionFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
