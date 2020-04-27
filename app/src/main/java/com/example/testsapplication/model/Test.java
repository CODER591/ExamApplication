package com.example.testsapplication.model;

import java.util.List;


public class Test {

   private String mTestName;
   private String mDescription; 
   private List<Question> mQuestions;

   public Test(){

   }
   public Test(List<Question>list,String name,String description) {
        mQuestions = list;
        mTestName = name;
        mDescription = description;
   }
   public String getDescription() {
       return mDescription;
   }
   public String getTestName() {
        return mTestName;
   }
   public int getQuestionsCount() {
       return mQuestions.size();
   }
   public List<Question> getQuestions() {
       return mQuestions;
   }
}