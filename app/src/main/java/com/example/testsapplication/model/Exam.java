package com.example.testsapplication.model;

import com.example.testsapplication.composeexamdb.ExamDB;

import java.util.ArrayList;
import java.util.List;



//should manage the running test directly
public class Exam {
        private String mExamName;
        private String mExamDescription;
        private int mPosition;
        List<Question> mQuizList;  // those questions should be replaced on another entity that would know whether it answered or Not
        public  Exam() {

        }
        public Exam(Test test) {
                mExamName = test.getTestName();
                mExamDescription = test.getDescription();
                List<Question> imported_qs= test.getQuestions();
                mQuizList=new ArrayList<>();
                for(int i = 0; i < 10; i++) {
                        //HERE IS BUG we can push in list some duplicated questions
                        int random =(int) Math.random() * imported_qs.size();
                        mQuizList.add(imported_qs.get(random));
                }
                mPosition=0;
        }
        public void startExam() {

        }
        public void endExam() {

        }
        public void answerQuestion(int q_id) {
                mPosition++;
        }
        public int getPosition(){
                return mPosition;
        }
        public void skipQuestion() {
                mPosition++;
        }
        public Question getCurrentQuestion() {
                return mQuizList.get(mPosition);  //refactor
        }

        public String getName(){
                return mExamName;
        }
        public String getDescription() {
                return mExamDescription;
        }
}


