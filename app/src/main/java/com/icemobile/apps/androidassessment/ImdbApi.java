package com.icemobile.apps.androidassessment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImdbApi {
    @GET("?apikey=1b23a42&t=inception")
    Call<MovieResult> getMovie();
}
