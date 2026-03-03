package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTakeUntilExample01 {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .takeUntil((Car car) -> car.getCarName().equals("트랙스"))
                .subscribe(car -> System.out.println(car.getCarName()));

        TimeUtil.sleep(300L);
    }
}
