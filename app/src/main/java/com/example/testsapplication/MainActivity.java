package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.*;

import com.example.testsapplication.composeexamdb.ContextToJson;
import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.testmanager.ShowTestAdapter;
import com.example.testsapplication.testmanager.TestManager;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mTestsListView;
    private ShowTestAdapter mTestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContextToJson maindb;
        ExamDB exam;
        try {
            maindb = new ContextToJson(this);
            exam = new ExamDB(maindb);
            TestManager.getInstance().setImportedDb(exam.GetAllTests());

            mTestsListView = findViewById(R.id.rv_layout);
            LinearLayoutManager manager =new LinearLayoutManager(this);
            mTestsListView.setLayoutManager(manager);
            mTestsListView.setHasFixedSize(true);

            mTestAdapter = new ShowTestAdapter(exam.GetAllTestsNames());
            mTestsListView.setAdapter(mTestAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
