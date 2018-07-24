package com.baris.jokedisplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @NonNull
    private static final String NEW_JOKE = "new_joke";

    public static Intent jokeDisplayerIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(NEW_JOKE, joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_joke);

        TextView jokes = findViewById(R.id.joke_tv);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(NEW_JOKE);

        if (joke == null || joke.isEmpty()) {
            jokes.setText(R.string.joke_retrieve_error);
        } else {
            jokes.setText(joke);
        }

        ActionBar bar = this.getSupportActionBar();

        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
