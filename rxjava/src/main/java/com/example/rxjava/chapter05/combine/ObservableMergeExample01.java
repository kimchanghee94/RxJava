package com.example.rxjava.chapter05.combine;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableMergeExample01 {
    public static void main(String[] args){
        Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS).take(5);
        Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS).take(5)
                .map(num -> num+1000);

        Observable.merge(observable1, observable2).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(4000);
    }
}
