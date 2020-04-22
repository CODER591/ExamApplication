package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import org.json.*;

import ExamPack.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView vieeew = findViewById(R.id.json_disp);
        String result="{\"name\":\"Test1\",\"description\":\"Cool and inspiring description\",\"questions\":[{\"question\":\"some question first\",\"answers\":[{\"answer\":\"first_answer\",\"is_correct\":\"false\"},{\"answer\":\"second_answer\",\"is_correct\":\"false\"},{\"answer\":\"third_answer\",\"is_correct\":\"true\"},{\"answer\":\"forth_answer\",\"is_correct\":\"false\"}]},{\"question\":\"some question second\",\"answers\":[{\"answer\":\"first_answer\",\"is_correct\":\"false\"},{\"answer\":\"second_answer\",\"is_correct\":\"true\"},{\"answer\":\"third_answer\",\"is_correct\":\"false\"},{\"answer\":\"forth_answer\",\"is_correct\":\"false\"}]}]}";
        try {
            JSONObject jObject = new JSONObject(result);
            Test tst =new  Test(jObject);
            vieeew.setText("SEE the might ?");
        } catch (JSONException e) {
            vieeew.setText("ASS we can");
            e.printStackTrace();
        }

    }
}
