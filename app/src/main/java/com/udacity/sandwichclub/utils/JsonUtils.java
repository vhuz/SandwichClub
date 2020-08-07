package com.udacity.sandwichclub.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.MainActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

    // parsing data from string-array sandwich_details
    // (located in strings.xml)

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        Sandwich parsedData = new Sandwich();

        JSONObject rootJSON_OBJECT = new JSONObject(json);
        JSONObject rawJSON_OBJECT = rootJSON_OBJECT.getJSONObject("name");

        // setting Main Name
        String mainName = rawJSON_OBJECT.getString("mainName");
        parsedData.setMainName(mainName);

        // setting 'alsoKnownAs' name
//        List<String> list = null;
//        JSONArray secondName = rawJSON_OBJECT.getJSONArray("alsoKnownAs");
//
//        if (secondName.length() != 0 & secondName != null) {
//            for (int i = 0; i < secondName.length(); i++) {
//                list.add(secondName.getString(i));
//            }
//        }

//        if (list != null) {
//            parsedData.setAlsoKnownAs(list);
//        } else {
//            parsedData.setAlsoKnownAs(Arrays.asList(""));
//        }

        parsedData.setAlsoKnownAs(Arrays.asList("sup1", "sup2", "sup3"));


        // setting 'description'
        parsedData.setDescription(rootJSON_OBJECT.getString("description"));

        // setting 'placeOfOrigin'
        parsedData.setPlaceOfOrigin(rootJSON_OBJECT.getString("placeOfOrigin"));

        // setting 'image'
        parsedData.setImage(rootJSON_OBJECT.getString("image"));

        // setting 'ingredients'

//        List<String> list2 = null;
//        JSONArray ingredientsArray = rootJSON_OBJECT.getJSONArray("ingredients");
//
//        if (ingredientsArray.length() != 0 && ingredientsArray != null) {
//            for (int i = 0; i < ingredientsArray.length(); i++) {
//                String currentName = ingredientsArray.getString(i);
//                list2.add(currentName);
//            }
//        }
//
//        if (list2 != null) {
//            parsedData.setIngredients(list2);
//        } else {
//            parsedData.setIngredients(Arrays.asList(""));
//        }

        parsedData.setIngredients(Arrays.asList("sup1", "sup2", "sup3"));

        return parsedData;
    }
}
