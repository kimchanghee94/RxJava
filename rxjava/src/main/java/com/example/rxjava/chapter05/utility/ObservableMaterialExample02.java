package com.example.rxjava.chapter05.utility;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

public class ObservableMaterialExample02 {
    public static void main(String[] args){
        //concatEager은 Observable이 동시에 실행되는것
        Observable.concatEager(
                Observable.just(
                        getDBUser().subscribeOn(Schedulers.io()),
                        getAPIUser().subscribeOn(Schedulers.io())
                                .materialize()
                                .map(noti -> {
                                    if(noti.isOnError())
                                        Logger.log(LogType.PRINT,"# API User 에러 발생!");
                                    return noti;
                                })
                                .filter(noti -> !noti.isOnError())
                                .dematerialize(noti -> noti)
                )
        ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(5000L);
    }

    private static Observable<String> getDBUser(){
        return Observable.fromIterable(Arrays.asList("DB user1","DB user2","DB user3","DB user4","DB user5"));
    }

    private static Observable<String> getAPIUser(){
        return Observable.just("API user1","API user2","Not User","API user4","API user5")
                .map(user -> {
                    if(user.equals("Not User")) throw new RuntimeException();
                    return user;
                });
    }
}
