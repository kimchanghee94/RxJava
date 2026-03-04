package com.example.rxjava.chapter05.utility;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimeOutExample {
    public static void main(String[] args){
        Observable.range(1, 6)
                .map(num -> {
                    long time = 1000L;
                    if(num==4) time = 1500L;
                    TimeUtil.sleep(time);
                    return num;
                })
                .timeout(1200L, TimeUnit.MILLISECONDS)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }
}
