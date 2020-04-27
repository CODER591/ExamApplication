package com.example.testsapplication.composeexamdb;

import com.example.testsapplication.model.Test;

import java.util.List;

public interface JsonBasedExamDB {
    List<Test> GetAllTests();
}
