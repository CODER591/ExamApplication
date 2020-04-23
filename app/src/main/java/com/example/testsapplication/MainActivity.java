package com.example.testsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.*;

import com.example.testsapplication.composeexamdb.ExamDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.getResources().openRawResource(R.raw.first_test);
        TextView vieeew = findViewById(R.id.json_disp);
        String result="{\"name\":\"Test1\",\"description\":\"Cool and inspiring description\",\"questions\":[{\"question_body\":\"some question first\",\"answers\":[{\"answer\":\"first_answer\",\"is_correct\":\"false\"},{\"answer\":\"second_answer\",\"is_correct\":\"false\"},{\"answer\":\"third_answer\",\"is_correct\":\"true\"},{\"answer\":\"forth_answer\",\"is_correct\":\"false\"}]},{\"question_body\":\"some question second\",\"answers\":[{\"answer\":\"first_answer\",\"is_correct\":\"false\"},{\"answer\":\"second_answer\",\"is_correct\":\"true\"},{\"answer\":\"third_answer\",\"is_correct\":\"false\"},{\"answer\":\"forth_answer\",\"is_correct\":\"false\"}]}]}";
        try {
            JSONObject jObject = new JSONObject(result);
            ExamDB database =new ExamDB();
            database.getTest(jObject);
            vieeew.setText("See the might ?");
        } catch (JSONException e) {
            vieeew.setText("No might");
            e.printStackTrace();

        }

    }
}
