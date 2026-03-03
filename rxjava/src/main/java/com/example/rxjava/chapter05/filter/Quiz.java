package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import javax.xml.crypto.Data;
import java.util.concurrent.TimeUnit;

public class Quiz {
    public static void main(String[] args) throws InterruptedException{
//        Observable.fromIterable(SampleData.carList)
//                .filter((Car car) -> car.getCarMaker()== CarMaker.SSANGYOUNG)
//                .subscribe(data-> Logger.log(LogType.ON_NEXT, data.getCarName()));

//        Observable.interval(1000L, TimeUnit.MILLISECONDS)
//                .takeWhile(data -> data!=10)
//                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

//        Observable.interval(1000L, TimeUnit.MILLISECONDS)
//                .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS))
//                .takeWhile(data -> data<11)
//                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Observable.range(1,15)
                .skipLast(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(13000L);
    }
}
