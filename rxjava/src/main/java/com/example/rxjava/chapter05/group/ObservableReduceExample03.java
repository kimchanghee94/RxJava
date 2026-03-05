package com.example.rxjava.chapter05.group;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableReduceExample03 {
    public static void main(String[] args){
        Observable.just("a","b","c","d","e")
//                .doOnNext(data->Logger.log(LogType.DO_ON_NEXT, data))
                .reduce((a,b)->"(" + a + ", " + b + ")")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, "# 1부터 10까지의 누적 합계: " + data));
    }
}
