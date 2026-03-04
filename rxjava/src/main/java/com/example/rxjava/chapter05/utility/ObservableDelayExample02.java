package com.example.rxjava.chapter05.utility;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableDelayExample02 {
    public static void main(String[] args){
        //람다식으로 사용시 통지되는 데이터 각각에 지연 시간을 적용한다
        Observable.just(1,3,5,7)
                .delay(item -> {
                    TimeUtil.sleep(1000L);
                    return Observable.just(item);
                })
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
