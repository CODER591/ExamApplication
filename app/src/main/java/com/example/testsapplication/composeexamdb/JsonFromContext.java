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

public class JsonFromContext {

    JSONObject json_db;
    public JsonFromContext(Context context) throws JSONException {

            InputStream stream = context.getResources().openRawResource(R.raw.first_test);
            json_db= new JSONObject(id_toString(stream));
    }

    public JSONObject getJsonDB() {
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
