package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.testsapplication.testmanager.TestManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button main_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_button=findViewById(R.id.main_button);
        ContextToJson maindb;
        List<Test> List_with_tests;
        ExamDB exam;
        try {
            maindb = new ContextToJson(this);
            exam=new ExamDB(maindb);
            List_with_tests = exam.GetAllTests();
            TestManager.getInstance().setImportedDb(exam.GetAllTests());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TestManager.getInstance().startTest(0);
            }

        });


    }
}
