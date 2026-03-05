package com.example.rxjava.chapter05.group;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableScanExample03 {
    public static void main(String[] args){
        //scan은 reduce와 달리 매 데이터를 반환하고 초기값의 경우 scan처리하지 않고 바로 반환해주는 특징이 있다.
        Observable.just("a","b","c","d","e")
//                .doOnNext(data->Logger.log(LogType.DO_ON_NEXT, data))
                .scan((a,b)->"(" + a + ", " + b + ")")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, "# 1부터 10까지의 누적 합계: " + data));
    }
}
