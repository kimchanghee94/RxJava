package com.example.rxjava.chapter05.converter2;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class ObservableGroupByExample01 {
    public static void main(String[] args){
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList).groupBy(car -> car.getCarMaker());

        observable.subscribe(
                groupedObservable -> groupedObservable.subscribe(
                        car-> Logger.log(
                                LogType.ON_NEXT, "Group: "+
                                        groupedObservable.getKey() + "\t Car name: " + car.getCarName())
                )
        );
    }
}
