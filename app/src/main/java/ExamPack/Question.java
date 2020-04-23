package ExamPack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private List<Answer> answers;
    private String body;

    public Question(List<Answer> answers,String body) throws JSONException {
        this.answers = answers;
        this.body = body;
    }
    public String getBody() {
        return body;
    }
    public int getAnswerCount() {
        return answers.size();
    }
}
