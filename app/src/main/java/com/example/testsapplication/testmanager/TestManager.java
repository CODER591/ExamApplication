package com.example.testsapplication.testmanager;


//singleton

// should manage running test

import com.example.testsapplication.modelspack.Question;
import com.example.testsapplication.modelspack.Test;

import java.util.ArrayList;
import java.util.List;

public class TestManager {
    private static final TestManager INSTANCE = new TestManager();
    private static List<Test> imported_db;  // all parsed json is here
    private static Test  owned_test; //test that we are passing
    private
    TestManager() {

    }
    public static TestManager getInstance() {
        return INSTANCE;
    }

    //Lets  rebuild our test by selecting random questions and setting new object to us;
    public static Test getOwnedTest(Test test) {
           return owned_test;
    }
    public static void setImportedDb(List<Test>list) {
        imported_db = list;
    }

    public static void startTest(int test_id) {
        if(test_id > imported_db.size() || test_id <0) {
            return;
        }
        owned_test = imported_db.get(test_id);
        List<Question> imported_qs= owned_test.getQuestions();
        List<Question> quiz_list=new ArrayList<>();
        for(int i=0;i<10;i++) {
            //HERE IS BUG we can push in list some duplicated questions
            int random =(int) Math.random() * imported_qs.size();
            quiz_list.add(imported_qs.get(random));
        }
        owned_test = new Test(quiz_list,owned_test.getTestName(),owned_test.getDescription());

    }
}
