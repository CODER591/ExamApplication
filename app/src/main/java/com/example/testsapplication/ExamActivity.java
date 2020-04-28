package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.testsapplication.testmanager.TestManager;

public class ExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start);

        final Button start_btn = findViewById(R.id.test_start_button);
        final TextView test_name_view = findViewById(R.id.test_name);
        final TextView test_description_view = findViewById(R.id.test_description);
        String testname = TestManager.getInstance().getOwnedTest().getTestName();
        String description = TestManager.getInstance().getOwnedTest().getDescription();
        test_name_view.setText(testname);
        test_description_view.setText(description);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is not working at all, for some reason
                Fragment questionFragment = new QuestionFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container, questionFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                // start test
                // start timer
                // go to fragment
            }
        });



    }
}
