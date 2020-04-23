package com.example.testsapplication.composeexamdb;

import com.example.testsapplication.modelspack.Test;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public interface JsonBasedExamDB {
    List<Test> GetAllTests();
}
