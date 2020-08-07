package com.udacity.sandwichclub.utils;

import android.text.TextUtils;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    // parsing data from string-array sandwich_details
    // (located in strings.xml)

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        Sandwich sandwich = new Sandwich();

        try {

            JSONObject rootJSON_OBJECT = new JSONObject(json);
            JSONObject rawJSON_OBJECT = rootJSON_OBJECT.getJSONObject("name");

            // setting Main Name
            String mainName = rawJSON_OBJECT.getString("mainName");
            sandwich.setMainName(mainName);

            // setting 'alsoKnownAs' name
            List<String> list = new ArrayList<String>();
            JSONArray firstList = rawJSON_OBJECT.getJSONArray("alsoKnownAs");
            if (firstList.length() != 0) {
                for (int i = 0; i < firstList.length(); i++) {
                    list.add(firstList.optString(i));
                }
            }
            sandwich.setAlsoKnownAs(list);

            // setting 'description'
            sandwich.setDescription(rootJSON_OBJECT.getString("description"));

            // setting 'placeOfOrigin'
            sandwich.setPlaceOfOrigin(rootJSON_OBJECT.getString("placeOfOrigin"));

            // setting 'image'
            sandwich.setImage(rootJSON_OBJECT.getString("image"));

            // setting 'ingredients'
            List<String> list2 = new ArrayList<String>();
            JSONArray secondList = rootJSON_OBJECT.getJSONArray("ingredients");
            if (secondList.length() != 0) {
                for (int i = 0; i < secondList.length(); i++) {
                    list2.add(secondList.optString(i));
                }
            }
                sandwich.setIngredients(list2);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
