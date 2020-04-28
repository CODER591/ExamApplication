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

        JSONProvider loaded_json_resource;
        ExamDB exam;
        try {
            loaded_json_resource = new JSONProvider();
            loaded_json_resource.loadJSONFromResourceFile(getApplicationContext(),R.raw.first_test);
            exam = new JsonBasedExamDB(loaded_json_resource.getJsonDB());


            // TestApplication app = new TestApplication(exam);
           // TestManager.getInstance().setImportedDb(database.getAllTests());

            TestManager.getInstance().setImportedDb(exam.getAllTests());
            mTestsListView = findViewById(R.id.rv_layout);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            mTestsListView.setLayoutManager(manager);
            mTestsListView.setHasFixedSize(true);
            mTestAdapter = new TestAdapter(exam.getAllTests());
            mTestsListView.setAdapter(mTestAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }








    }
}
