package ExamPack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class Answer {
   private boolean is_correct;
   private String ans_body;
    Answer(String body,boolean correct) {
     this.ans_body = body;
     this.is_correct = correct;
    }
    public Answer(JSONObject data) throws JSONException {
        this.ans_body = data.getString("answer");
        this.is_correct = data.getBoolean("is_correct");
    }

    public String getAnsBody() {
        return ans_body;
    }

    public boolean is_Correct() {
        return is_correct;
    }
}

class Question {
    private List<Answer> answers;
    private Answer right_answer;
    private String body;

   public Question(JSONObject data) throws JSONException {
        answers = new ArrayList<>();
        this.body = data.getString("question");
        JSONArray answersArray = data.getJSONArray("answers");
        for(int k=0;k < answersArray.length(); k++) {
            JSONObject answer = answersArray.getJSONObject(k);
            Answer tmp_ans= new Answer(answer);
            answers.add(tmp_ans);

        }
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
   private List<Question> questions;

   public Test(JSONObject data) throws JSONException {
       questions = new ArrayList<>();
       this.test_name = data.getString("name");
       this.description =data.getString("description");
       JSONArray questionsArray = data.getJSONArray("questions");
       for (int i = 0; i < questionsArray.length(); i++) {
           //JSONArray consist of JSONObjects;
           /*One iteration is one question*/
           JSONObject question = questionsArray.getJSONObject(i);
           Question tmp_quest= new Question(question);
           questions.add(tmp_quest);

       }
   }
   public String getDescription() {
       return description;
   }
   public String getTestName() {
        return test_name;
    }


}
