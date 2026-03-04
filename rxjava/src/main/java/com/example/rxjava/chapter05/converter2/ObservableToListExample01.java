package com.example.rxjava.chapter05.converter2;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class ObservableToListExample01 {
    public static void main(String[] args){
        Single<List<Integer>> single = Observable.just(1,3,5,7,9).toList();
        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
