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
    private static List<Test> sImportedDb;   // all parsed json is here
    private static Test  sOwnedTest; //test that we are passing
    private static int sPosition;
    //Should this class have inside some  timer?
    //this manager should own answered questions.
    //this manager should own skipped questions.
    TestManager() {

    }
    public static TestManager getInstance() {
        return INSTANCE;
    }
    public static Test getOwnedTest(Test test) {
           return sOwnedTest;
    }
    public static void setImportedDb(List<Test>list) {
        sImportedDb = list;
    }
    //Lets  rebuild our test by selecting random questions and setting new object to us;
    public static void startTest(int test_id) {
        if(test_id > sImportedDb.size() || test_id <0) {
            return;
        }
        sOwnedTest = sImportedDb.get(test_id);
        List<Question> imported_qs= sOwnedTest.getQuestions();
        List<Question> quiz_list=new ArrayList<>();
        for(int i=0;i<10;i++) {
            //HERE IS BUG we can push in list some duplicated questions
            int random =(int) Math.random() * imported_qs.size();
            quiz_list.add(imported_qs.get(random));
        }
        sOwnedTest = new Test(quiz_list,sOwnedTest.getTestName(),sOwnedTest.getDescription());
        sPosition=0;
    }
    public static void endTest(){
        //get some results
        //maybe stop the timer?
        //??
    }
    //answer index is number of answer on plate (number of checkbox)
    public static void answerQuestion(int answer_index) {
        if(sPosition>sOwnedTest.getQuestionsCount()) { return; }


        //????
        sPosition++;//lets move to next question
    }
    //here we should know what question we are now dealing
    public static int getPosition(){
            return sPosition;
    }
    public static Question getCurrentQuestion(){
        return sOwnedTest.getQuestions().get(sPosition);
    }
    public  static void skipQuestion() {
        sPosition++;
    }
}
