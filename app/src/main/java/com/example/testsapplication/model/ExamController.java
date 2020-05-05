package com.example.testsapplication.model;

import android.os.CountDownTimer;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


//should manage the running test directly
public class ExamController {
        private String mExamName;
        private String mExamDescription;
        private int mPosition;
        List<Question> mQuizList;  // those questions should be replaced on another entity that would know whether it answered or Not
        private Integer mExamQuestionsCount;

        private int mCorrectAnswers;
        private int mSkippedQuestions;
        private List <Integer> mQnA; //this list contains id of provided answer

        private CountDownTimer mCountDownTimer;
        private long mTimeLeftInMillis;

        public ExamController() {


        }
        public ExamController(Test test) {
                mExamName = test.getTestName();
                mExamDescription = test.getDescription();
                mExamQuestionsCount = test.getQuestionsInExam();
                List<Question> imported_qs= test.getQuestions();
                mQuizList = new ArrayList<>();
                importRandomQuestions(imported_qs);
                mQnA = new ArrayList<>(Collections.nCopies(mExamQuestionsCount, 0));
                mPosition = 0;
                mTimeLeftInMillis=300000;
                mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                mTimeLeftInMillis = millisUntilFinished;
                        }
                        @Override
                        public void onFinish() {

                        }
                };
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
                mCountDownTimer.start();
        }
        public void endExam() {
                mCountDownTimer.cancel();
        }
        public String  getTimeLeft() {
                int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
                int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
                return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
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
                List<Question> tmp_list= new ArrayList<>(imported_qs);
                for(int i = 0; i < mExamQuestionsCount; i++) {
                        //FIX ME !!
                        //HERE IS BUG we can push in list some duplicated questions
                        int random = (int) (Math.random() * imported_qs.size());
                        mQuizList.add(imported_qs.get(random));
                }
                /*
                for(int i = 0; i < mExamQuestionsCount; i++) {
                        //FIX ME !! FIXED
                        //HERE IS BUG we can push in list some duplicated questions
                        int random =(int) (Math.random() * imported_qs.size());
                        try {
                                mQuizList.add(tmp_list.get(random));
                                tmp_list.remove(random);
                        }
                        catch (Exception e) {
                                e.printStackTrace();
                        }

                }*/
                /*FIXED COMMENT:
                * Because of the repeated random number sometimes this element already deleted in tmp list, so we are getting crash sometimes*/
        }
}


