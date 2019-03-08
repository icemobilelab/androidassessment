package com.icemobile.apps.androidassessment;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MovieRepo {

    public void getMovie(final ResultHandler<MovieResult> handler) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build();

        ImdbApi api = retrofit.create(ImdbApi.class);


        api.getMovie().enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
                handler.onFailed("oops");
            }
        });

    }
}
