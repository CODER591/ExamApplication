package ExamPack;

import org.json.JSONException;
import org.json.JSONObject;

public class Answer {
    private boolean is_correct;
    private String ans_body;
    public Answer(String body,boolean correct) {
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
