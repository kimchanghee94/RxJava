package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTakeUntilExample02 {
    public static void main(String[] args){
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                    .takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS))
                    .subscribe(data-> Logger.log(LogType.ON_NEXT,data));

        TimeUtil.sleep(7500L);
    }
}
