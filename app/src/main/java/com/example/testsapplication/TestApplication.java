package com.example.testsapplication;

import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.model.Test;
import com.example.testsapplication.testmanager.TestManager;

public class TestApplication extends android.app.Application {
    //TestManagerInitialise
    public TestApplication(){}
    public TestApplication(ExamDB database) {
        TestManager.getInstance().setImportedDb(database.getAllTests());
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
    }
}
