package com.example.testsapplication.model;

import com.example.testsapplication.composeexamdb.ExamDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


//should manage the running test directly
public class Exam {
        private String mExamName;
        private String mExamDescription;
        private int mPosition;
        List<Question> mQuizList;  // those questions should be replaced on another entity that would know whether it answered or Not
        private int mExamQuestionsCount;

        private int mCorrectAnswers;
        private int mSkippedQuestions;
        private HashMap <Integer,Integer> mQandA; //this map contains index of question in mQiz list and also id of provided answer


        public  Exam() {

        }
        public Exam(Test test) {
                mExamName = test.getTestName();
                mExamDescription = test.getDescription();
                mExamQuestionsCount = 10;
                List<Question> imported_qs= test.getQuestions();
                mQuizList = new ArrayList<>();
                mQandA = new HashMap<>();
                for(int i = 0; i < mExamQuestionsCount; i++) {
                        //FIX ME !!
                        //HERE IS BUG we can push in list some duplicated questions
                        int random =(int) (Math.random() * imported_qs.size());
                        mQuizList.add(imported_qs.get(random));
                }
                mPosition = 0;
        }
        public int getPosition(){
                return mPosition;
        }
        public void skipQuestion() {
                mQandA.put(mPosition, -1);
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
                setResults();
                //stop timer
        }
        //answer index is number of answer on plate (number of checkbox)
        public void answerQuestion(int ans_id) {
                mQandA.put(mPosition, ans_id);
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
        private  void setResults() {
                for (Map.Entry<Integer, Integer> entry : mQandA.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        if(value==-1) {
                                mSkippedQuestions++;
                        } else {
                                if(mQuizList.get(key.intValue()).getAnswers().get(value.intValue()).is_Correct()){
                                        mCorrectAnswers++;
                                }
                        }

                }

        }
}


