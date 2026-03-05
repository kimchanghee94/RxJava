package com.example.rxjava.chapter05.group;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableCountExample01 {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .count()
                .subscribe(data-> Logger.log(LogType.ON_NEXT, data));
    }
}
