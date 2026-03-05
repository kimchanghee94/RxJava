package com.example.rxjava.chapter05.group;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableReduceExample02 {
    public static void main(String[] args){
        Observable.just(1,2,3,4,5,6,7,8,9,10)
//                .doOnNext(data->Logger.log(LogType.DO_ON_NEXT, data))
                .reduce(0, (a,b)->{
                    Logger.log(LogType.PRINT, "# reduce 입력 값 : " + a + ", "+  b);
                    return a+b;
                })
                .subscribe(data -> Logger.log(LogType.ON_NEXT, "# 1부터 10까지의 누적 합계: " + data));
    }
}
