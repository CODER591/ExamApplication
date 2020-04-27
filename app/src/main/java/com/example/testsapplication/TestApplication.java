package com.example.testsapplication;

import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.model.Test;
import com.example.testsapplication.testmanager.TestManager;

public class TestApplication extends android.app.Application {
    //TestManagerInitialise
    TestApplication(ExamDB database) {
        TestManager.getInstance().setImportedDb(database.getAllTests());
    }

}
