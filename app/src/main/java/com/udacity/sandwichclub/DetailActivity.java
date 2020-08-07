package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);
        TextView mainName = findViewById(R.id.main_name_tv);
        TextView alsoKnownAs = findViewById(R.id.also_known_tv);
        TextView ingrText = findViewById(R.id.ingredients_tv);
        TextView descrText = findViewById(R.id.description_tv);
        TextView originText = findViewById(R.id.origin_tv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = null;
        sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich, mainName, alsoKnownAs, ingrText, descrText, originText);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich, TextView mainName, TextView alsoKnownAs, TextView ingrText, TextView descrText, TextView originText) {

        String mText;
        mText = sandwich.getMainName();
        mainName.setText(mText);
        mText = String.valueOf(sandwich.getAlsoKnownAs()).substring(1);
        mText = mText.substring(0, (mText.length() - 1));
        alsoKnownAs.setText(mText);
        mText = String.valueOf(sandwich.getIngredients()).substring(1);
        mText = mText.substring(0, (mText.length() - 1));
        ingrText.setText(mText);
        mText = sandwich.getDescription();
        descrText.setText(mText);
        mText = sandwich.getPlaceOfOrigin();
        originText.setText(mText);

    }
}
