package com.example.rxjava.chapter08;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import org.apache.commons.logging.Log;

public class DoOnNextExample {
    public static void main(String[] args){
        Observable.just(1,3,5,7,9,10,11,12,13)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "#원본 통지 데이터: " + data))
                .filter(data -> data < 10)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "#filter 적용 후: " + data))
                .map(data -> "#### " + data + " ####")
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"#map 적용 후: " + data))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, "#최종 데이터: " + data));
    }
}
