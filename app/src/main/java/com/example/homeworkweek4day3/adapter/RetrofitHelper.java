package com.example.homeworkweek4day3.adapter;

import com.example.homeworkweek4day3.model.user.UserResponse;
import com.example.homeworkweek4day3.rest.UrlConstants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.homeworkweek4day3.rest.UrlConstants.PATH;

public class RetrofitHelper {
    //create retrofit client
    private Retrofit getRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                //Uses gson behind the scenes to make the result object
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //build the retrofit service
    private GetRandomUsers getUserResponse() {
        return getRetrofitClient().create(GetRandomUsers.class);
    }
    //get the response
    public Call<UserResponse> getRandomUsers(String numOfResponses) {
        return getUserResponse().getRandomUsers();
    }


    public interface GetRandomUsers{
        @GET(PATH)
        Call<UserResponse> getRandomUsers();
    }

}


