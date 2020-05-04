package com.example.testsapplication.model;

import com.example.testsapplication.composeexamdb.ExamDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


//should manage the running test directly
public class ExamController {
        private String mExamName;
        private String mExamDescription;
        private int mPosition;
        List<Question> mQuizList;  // those questions should be replaced on another entity that would know whether it answered or Not
        private int mExamQuestionsCount;

        private int mCorrectAnswers;
        private int mSkippedQuestions;
        private List <Integer> mQnA; //this list contains index of question in mQiz list and also id of provided answer


        public ExamController() {

        }
        public ExamController(Test test) {
                mExamName = test.getTestName();
                mExamDescription = test.getDescription();
                mExamQuestionsCount = 10;
                List<Question> imported_qs= test.getQuestions();
                mQuizList = new ArrayList<>();
                mQnA = new ArrayList<>(Collections.nCopies(mExamQuestionsCount, 0));
                importRandomQuestions(imported_qs);
                mPosition = 0;
        }
        public int getPosition(){
                return mPosition;
        }
        public void skipQuestion() {
                mQnA.set(mPosition, -1);
                mSkippedQuestions++;
                moveToNext();
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
        public void answerQuestion(int ans_id) {
                mQnA.set(mPosition,ans_id);
                if(mQuizList.get(mPosition).getAnswers().get(ans_id).is_Correct()){
                        mCorrectAnswers++;
                }
                moveToNext();
        }
        private void moveToNext() {
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
        private void importRandomQuestions(List<Question>imported_qs) {
                for(int i = 0; i < mExamQuestionsCount; i++) {
                        //FIX ME !!
                        //HERE IS BUG we can push in list some duplicated questions
                        int random =(int) (Math.random() * imported_qs.size());
                        mQuizList.add(imported_qs.get(random));
                }
        }
}


