package com.example.testsapplication.modelspack;

import java.util.List;


public class Test {

   private String mTestName;
   private String mDescription; 
   private List<Question> questions;

   public Test(){

   }
   public Test(List<Question>list,String name,String description) {
        this.questions = list;
        this.mTestName = name;
        this.mDescription = description;
   }

   public String getDescription() {
       return mDescription;
   }

   public String getTestName() {
        return mTestName;
   }

   public int getQuestionsCount() {
       return questions.size();
   }

   public List<Question> getQuestions() {
       return questions;
   }
}