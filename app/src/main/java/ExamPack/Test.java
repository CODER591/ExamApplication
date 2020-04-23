package ExamPack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Test {

   private String test_name;
   private String description;
   private List<Question> questions;

   public Test(JSONObject data) throws JSONException {
       questions = new ArrayList<>();
       this.test_name = data.getString("name");
       this.description = data.getString("description");
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

   public int getQuestionsCount() {
       return questions.size();
   }

   //public int getRightAnsweredCount();

}


//What means give answer to question?
//1) We are not checking whether answer is related to question( give it to interface user)
//2)