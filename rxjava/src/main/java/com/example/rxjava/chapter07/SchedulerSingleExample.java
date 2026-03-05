package com.example.rxjava.chapter07;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerSingleExample {
    public static void main(String[] args){
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        //첫번째 쓰레드만 생성하고 이를 트램펄린과 같은 형태도 동작한다. 모든 동작을 첫쓰레드가지고만 처리한다.
        observable.subscribeOn(Schedulers.single())
                        .map(data -> "## " + data + " ##")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        observable.subscribeOn(Schedulers.single())
                        .map(data -> "$$ " + data + " $$")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
