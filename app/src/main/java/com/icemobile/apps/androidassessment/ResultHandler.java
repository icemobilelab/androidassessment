package com.icemobile.apps.androidassessment;

public interface  ResultHandler<T> {
    void onSuccess(T result);
    void onFailed(String errormessage);
}
