package com.example.testsapplication.testmanager;

import com.example.testsapplication.model.Question;
import com.example.testsapplication.model.Test;

import java.util.ArrayList;
import java.util.List;


//singleton

// should manage running test
//Questions should display in random order, answers should display in as they are in db


public class TestManager {
    private static final TestManager INSTANCE = new TestManager();
    private List<Test> sImportedDb;   // all parsed json is here
    private Test  sOwnedTest; //test that we are passing
    private int sPosition;
    //Should this class have inside some  timer?
    //this manager should own answered questions.
    //this manager should own skipped questions.
    TestManager() {

    }
    public static TestManager getInstance() {
        return INSTANCE;
    }
    public void setOwnedTest(Test test) {
        sOwnedTest = test;
    }
    public void setOwnedTest(int test_position) {
        if(test_position > 0 && test_position < sImportedDb.size()) {
            sOwnedTest = sImportedDb.get(test_position);
        }
    }
    public Test getOwnedTest() {
           return sOwnedTest;
    }
    public void setImportedDb(List<Test>list) {
        sImportedDb = list;
    }
    //Lets  rebuild our test by selecting random questions and setting new object to us;
    public void startTest(int test_id) {
        if(test_id > sImportedDb.size() || test_id <0) {
            return;
        }
        sOwnedTest = sImportedDb.get(test_id);
        List<Question> imported_qs= sOwnedTest.getQuestions();
        List<Question> quiz_list=new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            //HERE IS BUG we can push in list some duplicated questions
            int random =(int) Math.random() * imported_qs.size();
            quiz_list.add(imported_qs.get(random));
        }
        sOwnedTest = new Test(quiz_list,sOwnedTest.getTestName(),sOwnedTest.getDescription());
        sPosition=0;
    }
    public void endTest(){
        //get some results
        //maybe stop the timer?
        //??
    }
    //answer index is number of answer on plate (number of checkbox)
    public void answerQuestion(int answer_index) {
        if(sPosition>sOwnedTest.getQuestionsCount()) { return; }

        //????

        sPosition++;//lets move to next question
    }
    //here we should know what question we are now dealing
    public int getPosition(){
            return sPosition;
    }
    public Question getCurrentQuestion(){
        return sOwnedTest.getQuestions().get(sPosition);
    }
    public void skipQuestion() {
        sPosition++;
    }
}
