package com.example.testsapplication;

import com.example.testsapplication.composeexamdb.ExamDB;
import com.example.testsapplication.testmanager.TestManager;

public class Application {
    //TestManagerInitialise
    Application(ExamDB database) {
        TestManager.getInstance().setImportedDb(database.GetAllTests());
    }

}
