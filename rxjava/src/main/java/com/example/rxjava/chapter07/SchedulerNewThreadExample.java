package com.example.rxjava.chapter07;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Collections;

public class SchedulerNewThreadExample {
    public static void main(String[] args){
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");
        observable.subscribeOn(Schedulers.newThread())
                        .map(data -> "## " + data + " ##")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        observable.subscribeOn(Schedulers.newThread())
                        .map(data -> "$$ " + data + " $$")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(500L);
    }
}
