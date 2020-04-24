package com.example.testsapplication.modelspack;

import java.util.List;


public class Test {

   private String test_name;
   private String description;
   private List<Question> questions;

   public Test(){

   }

   public Test(List<Question>list,String name,String description) {
        this.questions = list;
        this.test_name = name;
        this.description = description;
   }

   public String getDescription() {
       return description;
   }

   public String getTestName() {
        return test_name;
    }

   public int getQuestionsCount() {
       return questions.size();
   }

   public List<Question> getQuestions() {
       return questions;
   }
   //public int getRightAnsweredCount();

}


//What means give answer to question?
//1) We are not checking whether answer is related to question( give it to interface user)
//2)