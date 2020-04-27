package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.*;

import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.composeexamdb.JsonFromContext;
import com.example.testsapplication.composeexamdb.JsonBasedExamDB;
import com.example.testsapplication.testmanager.ShowTestAdapter;
import com.example.testsapplication.testmanager.TestManager;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mTestsListView;
    private ShowTestAdapter mTestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonFromContext maindb;
        ExamDB exam;
        try {
            maindb = new JsonFromContext(this);
            exam = new JsonBasedExamDB(maindb);
            Application app = new Application(exam);


            TestManager.getInstance().setImportedDb(exam.GetAllTests());

            mTestsListView = findViewById(R.id.rv_layout);
            LinearLayoutManager manager =new LinearLayoutManager(this);
            mTestsListView.setLayoutManager(manager);
            mTestsListView.setHasFixedSize(true);

            mTestAdapter = new ShowTestAdapter(((JsonBasedExamDB) exam).GetAllTestsNames());
            mTestsListView.setAdapter(mTestAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }








    }
}
