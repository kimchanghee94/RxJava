package com.example.rxjava.chapter05.combine;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatExample01 {
    public static void main(String[] args){
        Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS).take(4);
        Observable<Long> observable2 = Observable.interval(300L, TimeUnit.MILLISECONDS).take(5).map(n->n+1000);

        Observable.concat(observable1, observable2).subscribe(data->Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(3500L);
    }
}
