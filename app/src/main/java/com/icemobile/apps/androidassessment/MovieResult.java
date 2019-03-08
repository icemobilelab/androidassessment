package com.icemobile.apps.androidassessment;

import com.squareup.moshi.Json;

public class MovieResult {
    @Json(name = "Title")
    private String name;


    public String getName() {
        return name;
    }
}
