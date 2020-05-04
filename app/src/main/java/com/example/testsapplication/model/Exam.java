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
        private int mExamQuestionsCount;

        private int mCorrectAnswers;
        private int mSkippedQuestions;


        public  Exam() {

        }
        public Exam(Test test) {
                mExamName = test.getTestName();
                mExamDescription = test.getDescription();
                mExamQuestionsCount = 10;
                List<Question> imported_qs= test.getQuestions();
                mQuizList = new ArrayList<>();
                for(int i = 0; i < mExamQuestionsCount; i++) {
                        //FIX ME !!
                        //HERE IS BUG we can push in list some duplicated questions
                        int random =(int) (Math.random() * imported_qs.size());
                        mQuizList.add(imported_qs.get(random));
                }
                mPosition=0;
        }
        public int getPosition(){
                return mPosition;
        }
        public void skipQuestion() {
                mSkippedQuestions++;
                mPosition++;
        }
        public Question getCurrentQuestion() {
                return mQuizList.get(mPosition);
        }
        public String getName(){
                return mExamName;
        }
        public String getDescription() {
                return mExamDescription;
        }
        public int getExamQuestionsCount(){
                return mExamQuestionsCount;
        }

        public void startExam() {
                //set up timer
        }
        public void endExam() {
                //stop timer
        }
        //answer index is number of answer on plate (number of checkbox)
        //also review after scoring refactoring
        public void answerQuestion(int ans_id) {
                if(getCurrentQuestion().checkAnswer(ans_id)) {
                        mCorrectAnswers++;
                }
                mPosition++;
        }
        public int getCorrectAnswers() {
                return mCorrectAnswers;
        }
        public int getSkippedQuestions() {
                return mSkippedQuestions;
        }
        public int getIncorrectAnswers() {
                return mExamQuestionsCount-mCorrectAnswers-mSkippedQuestions;
        }
        
}


