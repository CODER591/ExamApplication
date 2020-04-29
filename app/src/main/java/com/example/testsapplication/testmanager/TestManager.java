package com.example.testsapplication.testmanager;

import com.example.testsapplication.model.Exam;
import com.example.testsapplication.model.Question;
import com.example.testsapplication.model.Test;

import java.util.ArrayList;
import java.util.List;


//singleton

// should manage running test
//Questions should display in random order, answers should display in as they are in db


public class TestManager {
    private static final TestManager INSTANCE = new TestManager();
    private List<Test> mImportedDb;   // all parsed json is here
    private Exam mCurrentExam; //test that we are passing
    private int mPosition;
    TestManager() {

    }
    public static TestManager getInstance() {
        return INSTANCE;
    }
    public void setOwnedTest(Test test) {
        mCurrentExam = new Exam(test);
    }
    public void setOwnedTest(int test_position) {
        mCurrentExam = new Exam(mImportedDb.get(test_position));
    }
    public Exam getOwnedTest() {
        return mCurrentExam;
    }
    public void setImportedDb(List<Test>list) {
        mImportedDb = list;
    }
    public List<Test> getImportedDb(){
        return mImportedDb;
    }

    public void startTest() {
        mCurrentExam.startExam();
    }
    public void endTest(){
        mCurrentExam.endExam();
    }
    //answer index is number of answer on plate (number of checkbox)
    public void answerQuestion(int answer_index) {
        mCurrentExam.answerQuestion(answer_index);
    }
}
