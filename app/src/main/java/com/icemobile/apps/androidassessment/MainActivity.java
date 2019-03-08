package com.icemobile.apps.androidassessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MovieRepo().getMovie(new ResultHandler<MovieResult>() {
            @Override
            public void onSuccess(MovieResult result) {
                populateView(result);
            }

            @Override
            public void onFailed(String errorMessage) {
                showError(errorMessage);
            }
        });

    }

    private void populateView(MovieResult movie) {
        if (movie != null && !TextUtils.isEmpty(movie.getName())) {
            TextView movieNameView = findViewById(R.id.movie_name);
            movieNameView.setText(movie.getName().toUpperCase());
        }
    }

    private void showError(String error) {
        TextView movieNameView = findViewById(R.id.movie_name);
        movieNameView.setText(error);
    }
}
