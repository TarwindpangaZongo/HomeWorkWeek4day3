package com.example.homeworkweek4day3.view.adapter;



import com.example.homeworkweek4day3.model.repo.repo.RepoResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelperRepo {
    private static OkHttpClient getOkhttpClientWithIntercepter(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static Retrofit getRetrofut(){
        return new Retrofit
                .Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(getOkhttpClientWithIntercepter())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private ObservableInterface createRepoResponceInterface(){
        return getRetrofut().create(ObservableInterface.class);
    }

    public Observable<RepoResponse> getUserResponseObsevable(String numResults){
        return createRepoResponceInterface().fgetRepoResponseObservable(numResults);
    }

    public interface ObservableInterface{
        @GET(ApiConstants.PATH_API)
        Observable<RepoResponse> fgetRepoResponseObservable(
                @Query(ApiConstants.QUERY_RESULTS) String numOfResultsDesired);
    }
}
