package ExamPack;

import java.util.ArrayList;
import java.util.List;

class Answer {
    boolean is_correct;
    String ans_body;
    Answer(String body,boolean correct) {
     this.ans_body = body;
     this.is_correct = correct;
    }

    public String getAnsBody() {
        return ans_body;
    }

    public boolean is_Correct() {
        return is_correct;
    }
}

class Question {
    List<Answer> answers;
    Answer right_answer;
    String body;

    Question() {

    }
    public String getBody() {
        return body;
    }
    public  Answer getRightAnswer() {
        return right_answer;
    }

}

public class Test {

    
   private String test_name;
   private String description;
   List<Question> questions;


   Test(String Json_str) {

   }


}
