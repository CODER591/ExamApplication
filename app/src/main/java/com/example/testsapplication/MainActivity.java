package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.*;

import com.example.testsapplication.composeexamdb.ContextToJson;
import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.composeexamdb.JsonBasedExamDB;
import com.example.testsapplication.modelspack.Test;
import com.example.testsapplication.testmanager.ShowTestAdapter;
import com.example.testsapplication.testmanager.TestManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView TestsListView;
    private ShowTestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // this button should be substituted on the recycler view element
      //  main_button = findViewById(R.id.main_button);
        ContextToJson maindb;
        ExamDB exam;
        try {
            maindb = new ContextToJson(this);
            exam = new ExamDB(maindb);
            TestManager.getInstance().setImportedDb(exam.GetAllTests());

            TestsListView = findViewById(R.id.rv_layout);
            LinearLayoutManager manager =new LinearLayoutManager(this);
            TestsListView.setLayoutManager(manager);
            TestsListView.setHasFixedSize(true);

            testAdapter =new ShowTestAdapter(exam.GetAllTests().size());
            TestsListView.setAdapter(testAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    /*    main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TestManager.getInstance().startTest(0);
            }
        });*/
        /*TestsListView =findViewById(R.id.rv_layout);
        LinearLayoutManager manager =new LinearLayoutManager(this);
        TestsListView.setLayoutManager(manager);
        TestsListView.setHasFixedSize(true);

        testAdapter =new ShowTestAdapter(exam.GetAllTests().size());
        TestsListView.setAdapter(testAdapter);*/
    }
}
