package com.example.rxjava.chapter05.converter2;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class ObservableGroupByExample02 {
    public static void main(String[] args){
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList).groupBy(Car::getCarMaker);

        observable.subscribe(
                groupedObservable -> groupedObservable
                        .filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
                        .subscribe(
                        car-> Logger.log(
                                LogType.ON_NEXT, "Group: "+
                                        groupedObservable.getKey() + "\t Car name: " + car.getCarName())
                )
        );
    }
}
