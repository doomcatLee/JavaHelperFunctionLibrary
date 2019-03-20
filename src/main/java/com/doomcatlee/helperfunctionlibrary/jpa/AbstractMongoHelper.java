package com.doomcatlee.helperfunctionlibrary.jpa;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;

public class AbstractMongoHelper {

    /**
     * Given MongoRepository, converts all items in collection into JSONArray stringified
     * **/
    public static String toJsonFromMongoCollection(CrudRepository crudRepository) {
        JSONArray jsonArray = new JSONArray();
        try {
            crudRepository.findAll().forEach(obj -> jsonArray.put(new JSONObject(new Gson().toJson(obj))));
            return new JSONObject().put("result", jsonArray).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONObject().put("result", "Failed").toString();
        }
    }

    /**
     * Given MongoObject, converts the item into JSONObject stringified
     * **/
    public static String toJson(Object obj) {
        try {
            return new JSONObject(new Gson().toJson(obj)).toString();
        } catch (Exception ex) {
            return new JSONObject().put("result", "Failed").toString();
        }
    }
}
