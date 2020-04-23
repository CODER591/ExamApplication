package com.example.testsapplication.modelspack;

import org.json.JSONException;

import java.util.List;

public class Question {

    private List<Answer> answers;
    private String body;

    public Question(List<Answer> answers,String body) throws JSONException {
        this.answers = answers;
        this.body = body;
    }
    public String getBody() {
        return body;
    }
    public int getAnswerCount() {
        return answers.size();
    }
}
