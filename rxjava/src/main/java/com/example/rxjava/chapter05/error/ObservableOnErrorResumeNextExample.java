package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorResumeNextExample {
    public static void main(String[] args){
        Observable.just(5)
                .flatMap(num ->
                        Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(5)
                                .map(i -> num/i)
                                .onErrorResumeNext(e -> {
                                    Logger.log(LogType.PRINT,"#운영자에게 이메일 발송" + e.getMessage());
                                    return Observable.interval(200L, TimeUnit.MILLISECONDS)
                                            .take(5)
                                            .skip(1)
                                            .map(i -> num/i);
                                })
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(5000L);
    }
}
