package com.example.rxjava.chapter07;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerTrampolineExample {
    public static void main(String[] args){
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        //트램펄린은 큐방식으로 현재 실행되고 있는 쓰레드의 대기큐에 처리작업을 등록해서 순서대로 작업한다.
        observable.subscribeOn(Schedulers.trampoline())
                        .map(data -> "## " + data + " ##")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        observable.subscribeOn(Schedulers.trampoline())
                        .map(data -> "$$ " + data + " $$")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
