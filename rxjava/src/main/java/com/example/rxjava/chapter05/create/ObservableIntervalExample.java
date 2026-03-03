package com.example.rxjava.chapter05.create;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args){
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num+" count")
                .subscribe(data-> Logger.log(LogType.ON_NEXT,data));

        //interval함수는 별도 쓰레드로 돌아가기 때문에 main쓰레드 종료를 막아야한다.
        TimeUtil.sleep(3000);
    }
}
