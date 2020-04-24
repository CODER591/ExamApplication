package com.example.testsapplication.modelspack;

import org.json.JSONException;

import java.util.List;

public class Question {

    private List<Answer> answers;
    private String body;
    private int provided_answer;
    public Question(List<Answer> answers,String body) throws JSONException {
        this.answers = answers;
        this.body = body;
        provided_answer =-1;
    }
    public String getBody() {
        return body;
    }
    public int getAnswerCount() {
        return answers.size();
    }
    public int getProvidedAnswer(){ return provided_answer;}
    public void setAnswerIndex(int answer_index) {
        provided_answer = answer_index;
    }
}
