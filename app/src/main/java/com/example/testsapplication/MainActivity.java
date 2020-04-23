package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.*;

import com.example.testsapplication.composeexamdb.ContextToJson;
import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.composeexamdb.JsonBasedExamDB;
import com.example.testsapplication.modelspack.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            ContextToJson maindb = new ContextToJson(this);
            ExamDB exam=new ExamDB(maindb);
            List<Test> lst=exam.GetAllTests();
            int kek=10;
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
