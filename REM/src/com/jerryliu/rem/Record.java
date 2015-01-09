
package com.jerryliu.rem;

import org.json.JSONException;
import org.json.JSONObject;

import com.jerryliu.jrycore.bean.BaseJsonObject;
import com.jerryliu.jrycore.log.Liu;

public class Record extends BaseJsonObject {
    public final static String KEY_ID = "ID";
    public final static String KEY_CONTENT = "content";

    public long projectID;
    public String desc;

    private Record() {
    }

    public String toJsonString() {
        JSONObject jo = new JSONObject();
        try {
            jo.put(KEY_ID, this.getId());
            jo.put(KEY_CONTENT, desc);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jo.toString();
    }

    public Record fromJsonString(String s) {
        Record io = new Record();
        Liu.d("Item object fromString : " + s);

        JSONObject jo = null;
        try {
            jo = new JSONObject(s);
            io.setId(jo.getLong(KEY_ID));
            if (!jo.isNull(KEY_CONTENT)) {
                io.desc = jo.getString(KEY_CONTENT);
            }
        } catch (JSONException e) {
            io = null;
            e.printStackTrace();
        }

        return io;
    }
}
