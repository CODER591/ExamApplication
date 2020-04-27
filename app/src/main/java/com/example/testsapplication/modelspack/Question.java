package com.example.testsapplication.modelspack;

import java.util.List;

public class Question {

    private List<Answer> mAnswers;
    private String mBody;
    private int provided_answer;
    public Question(List<Answer> answers,String body) {
        mAnswers = answers;
        mBody = body;
        provided_answer =-1;
    }
    public String getBody() {
        return mBody;
    }
    public int getAnswerCount() {
        return mAnswers.size();
    }
    public int getProvidedAnswer(){ return provided_answer;}
    public void setAnswerIndex(int answer_index) {
        provided_answer = answer_index;
    }
}
