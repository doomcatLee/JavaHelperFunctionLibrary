package com.doomcatlee.helperfunctionlibrary.json;

import org.json.JSONObject;

public class JSONLog {

    /**
     *
     *  Returns success message in JSON.
     *
     * **/
    public static String successMessage() {
        return new JSONObject().put("result", "Success").toString();
    }

    /**
     *
     *  Returns failed message in JSON.
     *
     * **/
    public static String failedMessage() {
        return new JSONObject().put("result", "Failed").toString();
    }

    /**
     *
     *  Returns null pointer message in JSON.
     *
     * **/
    public static String nullPointerMessage(String missingObject) {
        return new JSONObject().put("result", missingObject + " not found").toString();
    }
}
