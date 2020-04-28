package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.*;

import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.composeexamdb.JSONProvider;
import com.example.testsapplication.composeexamdb.JsonBasedExamDB;
import com.example.testsapplication.testmanager.TestAdapter;
import com.example.testsapplication.testmanager.TestManager;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mTestsListView;
    private TestAdapter mTestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestsListView = findViewById(R.id.rv_layout);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mTestsListView.setLayoutManager(manager);
        mTestsListView.setHasFixedSize(true);
        mTestAdapter = new TestAdapter(TestManager.getInstance().getImportedDb());
        mTestsListView.setAdapter(mTestAdapter);

    }
}
