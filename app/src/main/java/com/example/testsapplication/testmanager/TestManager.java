package com.example.testsapplication.testmanager;

import com.example.testsapplication.model.ExamController;
import com.example.testsapplication.model.Test;

import java.util.List;


//singleton

// should manage running test
//Questions should display in random order, answers should display in as they are in db


public class TestManager {
    private static final TestManager INSTANCE = new TestManager();
    private List<Test> mImportedDb;   // all parsed json is here
    private ExamController mCurrentExam; //test that we are passing

    TestManager() {

    }
    public static TestManager getInstance() {
        return INSTANCE;
    }
    public void createExamFor(int test_position) {
        mCurrentExam = new ExamController(mImportedDb.get(test_position));
    }
    public ExamController getCurrentExam() {
        return mCurrentExam;
    }
    public void setImportedDb(List<Test>list) {
        mImportedDb = list;
    }
    public List<Test> getImportedDb(){
        return mImportedDb;
    }
}
