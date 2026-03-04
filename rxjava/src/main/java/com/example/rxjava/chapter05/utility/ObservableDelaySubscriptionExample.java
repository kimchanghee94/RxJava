package com.example.rxjava.chapter05.utility;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableDelaySubscriptionExample {
    public static void main(String[] args){
        Logger.log(LogType.PRINT,"#실행 시작 시간: " + TimeUtil.getCurrentTimeFormatted());

        //delaySubscription()은 소비자가 구독시, 생성 및 통지 자체를 지연시킴으로써 소비자에게 데이터가 전달되는 시간을 지연시킨다.
        Observable.just(1,3,4,6)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .delaySubscription(2000L, TimeUnit.MILLISECONDS)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2500L);
    }
}
