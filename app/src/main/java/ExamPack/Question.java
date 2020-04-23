package ExamPack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private List<Answer> answers;
    private Answer right_answer;
    private String body;
    private boolean answered_right;

    public Question(JSONObject data) throws JSONException {
        answers = new ArrayList<>();
        this.body = data.getString("question");
        JSONArray answersArray = data.getJSONArray("answers");
        for(int k=0;k < answersArray.length(); k++) {
            JSONObject answer = answersArray.getJSONObject(k);
            Answer tmp_ans= new Answer(answer);
            if(tmp_ans.is_Correct()) {this.right_answer=tmp_ans;}
            answers.add(tmp_ans);

        }
        answered_right=false; //check maybe this is redundant
    }

    public String getBody() {
        return body;
    }
    public  Answer getRightAnswer() {
        return right_answer;
    }
    public boolean isAnsweredRight(){
        return answered_right;
    }
    public int getAnswerCount() {
        return answers.size();
    }
    public boolean answerTheQuestion(Answer answer) {
        //NOTE: we rely on user`s mind that user would not provide not related answers to questions
        // or check with right answer if they are equal lexographically;
        if(answer.is_Correct()) {
            answered_right=true;
            return answered_right;
        }
        answered_right=false;
        return answered_right;
    }

}
