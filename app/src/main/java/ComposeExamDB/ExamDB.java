package ComposeExamDB;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ExamPack.Exam;
import ExamPack.Test;

// detect Json files by path and stringify them
public class ExamDB {

    private List<String> result; // should contain "cached" stringifiyerd Test`s Json`s

    public List<String> getDB() {
        return result;
    }
    public static Test getTest(String json) throws JSONException {
        JSONObject jObject = new JSONObject(json);
        return new Test(jObject);
    }


}
