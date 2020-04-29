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

        Bundle bundle = getIntent().getExtras();
        TestManager.getInstance().startTest(bundle.getInt("AdapterPosition"));
        Fragment startTestPageFragment = new StartTestPageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, startTestPageFragment);
        //if add to back stack here we got an empty page
        transaction.commit();

    }
}
