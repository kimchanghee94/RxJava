package com.example.rxjava.chapter05.combine;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample01 {
    public static void main(String[] args){
        Observable<Long> observable1 =
                Observable.interval(500L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# observable 1 : " + data))
                        .take(4);

        Observable<Long> observable2 =
                Observable.interval(700L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# observable 2 : " + data))
                        .take(7);

        Observable.combineLatest(observable1, observable2, (data1, data2) -> "data1 : " + data1 + "\tdata2: " + data2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(7000L);
    }
}
