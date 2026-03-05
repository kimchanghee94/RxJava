package com.example.rxjava.chapter05.group;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class Quiz {
    public static void main(String[] args){
        Observable.range(1, 9)
                .scan(10, (a,b)-> {
                    int x = 10-b;
                    return a-x;
                })
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
