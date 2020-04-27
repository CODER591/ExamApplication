package com.example.testsapplication.composeexamdb;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.testsapplication.R;
import com.example.testsapplication.modelspack.Answer;
import com.example.testsapplication.modelspack.Question;
import com.example.testsapplication.modelspack.Test;


// detect Json files by path and stringify them
public class ExamDB implements JsonBasedExamDB {

    private List<Test> tests;
    public ExamDB(ContextToJson json_data) throws JSONException {
        tests=new ArrayList<>();
        JSONObject base_json = json_data.getJsonDB();
        JSONArray Tests_json_arr = base_json.getJSONArray("test_arr");
        for(int i=0;i<Tests_json_arr.length();i++) {
            this.tests.add(this.getTest(Tests_json_arr.getJSONObject(i)));
        }
    }
    @Override
    public List<Test> GetAllTests() {
        return tests;
    }


    private Test getTest(JSONObject data) throws JSONException {
        return new Test(this.getQuestionList(data),data.getString("name"),data.getString("description"));
    }

    private List<Question> getQuestionList(JSONObject data) throws JSONException {
        List<Question> tmp_list = new ArrayList<>();
        JSONArray questionsArray = data.getJSONArray("questions");
        for (int i = 0; i < questionsArray.length(); i++) {
            //JSONArray consist of JSONObjects;
            /*One iteration is one question*/
            JSONObject question = questionsArray.getJSONObject(i);
            Question tmp_quest = getQuestion(question);
            tmp_list.add(tmp_quest);

        }
        return tmp_list;
    }
    private Question getQuestion(JSONObject data) throws JSONException {
        return new Question(this.getAnswersList(data),data.getString("question_body"));
    }

    private List<Answer> getAnswersList(JSONObject data) throws JSONException {
        List<Answer> tmp_list = new ArrayList<>();
        JSONArray answersArray = data.getJSONArray("answers");
        for(int k=0; k < answersArray.length(); k++) {
            JSONObject answer = answersArray.getJSONObject(k);
            Answer tmp_ans= this.getAnswer(answer);
            tmp_list.add(tmp_ans);

        }
        return tmp_list;
    }
    private Answer getAnswer(JSONObject data) throws JSONException {
        return new Answer(data.getString("answer"),data.getBoolean("is_correct"));

    }

    public List<String> GetAllTestsNames() {
        List<String>str=new ArrayList<>();
        for(int i=0;i<tests.size();i++) {
            str.add(tests.get(i).getTestName());
        }
        return str;
    }

}
