package com.example.testsapplication.composeexamdb;

import android.content.Context;

import com.example.testsapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ContextToJson {
    List<Integer> json_ids;
    List<JSONObject> json_db;
    public ContextToJson(Context context) throws JSONException {
        json_db = new ArrayList<>();
        json_ids = new ArrayList<>();

        json_ids.add(R.raw.first_test); // have new json, insert here // maybe should be changed on AssetsManager
        json_ids.add(R.raw.second_test);

        for(int i=0;i < json_ids.size();i++){
            InputStream stream = context.getResources().openRawResource(json_ids.get(i));
            json_db.add(new JSONObject(id_toString(stream)));
        }

    }

    public List<JSONObject> getJsonDB() {
        return json_db;
    }

    private String id_toString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}
