package com.example.homeworkweek4day3.view.adapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserResponseRepository {
    private RetrofitHelperRepo retrofitHelperRepo;

    //Instantiate retorfit helper
    public UserResponseRepository(){
        this.retrofitHelperRepo = new RetrofitHelperRepo();
    }

    //Subscribe to observable and schedule the threads
    public void getUserResponse(String results, String gender, UserResponseCallback userResponseCallback){
        retrofitHelperRepo.getUserResponseObsevable(results, gender)
                .subscribeOn(Schedulers.io())//thread that the observable will process request
                .observeOn(AndroidSchedulers.mainThread()) //thread the results will be postedon
                .subscribe(new UserResponseObsever(userResponseCallback)); //the observer that is subcribing
    }
}
