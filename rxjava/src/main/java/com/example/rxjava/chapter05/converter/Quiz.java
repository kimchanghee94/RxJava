package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class Quiz {
    public static void main(String[] args) {
        Observable.range(1,15)
                .filter(data -> data%2==0)
                .map(data -> data*data)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Observable.range(2,7)
                .filter(data -> data%2==0)
                .flatMap(
                        data-> Observable.range(1,9)
                                .map(row -> data + " * " + row + " = " + data*row)
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
