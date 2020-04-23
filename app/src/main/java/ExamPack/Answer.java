package ExamPack;

import org.json.JSONException;
import org.json.JSONObject;

public class Answer {
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
