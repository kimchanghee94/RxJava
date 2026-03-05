package com.example.rxjava.chapter05.condition;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableAmbExample {
    public static void main(String[] args){
        List<Observable<Integer>> observables = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA)
                        .delay(200L, TimeUnit.MILLISECONDS)
                        .doOnComplete(()->Logger.log(LogType.DO_ON_COMPLETE,"# branch A's sales")),
                Observable.fromIterable(SampleData.salesOfBranchC)
                        .delay(300L, TimeUnit.MILLISECONDS)
                        .doOnComplete(()->Logger.log(LogType.DO_ON_COMPLETE, "# branch B's sales")),
                Observable.fromIterable(SampleData.salesOfBranchC)
                        .delay(500L, TimeUnit.MILLISECONDS)
                        .doOnComplete(()->Logger.log(LogType.DO_ON_COMPLETE, "# branch C's sales"))
        );

        Observable.amb(observables)
                .doOnComplete(()->Logger.log(LogType.DO_ON_COMPLETE,"#완료"))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
