package com.example.homeworkweek4day3.view.adapter;

import android.util.Log;

import com.example.rxjava.model.user.UserResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserResponseObsever implements Observer<UserResponse> {
    UserResponse retunUserResponse;
    UserResponseCallback userResponseCallback;
    private static final String TAG = "TAG_OBESVER";

    public UserResponseObsever(UserResponseCallback userResponseCallback) {
        this.userResponseCallback = userResponseCallback;
    }


    @Override
    public void onSubscribe(Disposable d) {
        //when the observer subscribes to the observable, do anything
        //     needed to se up folr the response once it is received
        Log.d(TAG,"onSubcribe: SUBSCRIBED TO OBSERVABLE");
    }

    @Override
    public void onNext(UserResponse userResponse) {
        //this is wher ou responce will be received
        Log.d(TAG, "onNext: RESPONSE RECEIVED");
        retunUserResponse = userResponse;

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ERROR RETURNED");

    }

    @Override
    public void onComplete() {
        //return list
        Log.d(TAG,"onComplete: TASK IS COMOLETE RETURNING USER RESPONSE");
        userResponseCallback.OnSucess(retunUserResponse);

    }
}
