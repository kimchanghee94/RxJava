package com.example.rxjava.chapter05.converter2;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public class ObservableToMapExample02 {
    public static void main(String[] args){
        Single<Map<String, String>> single =
                Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
                        .toMap(data -> data.split("-")[0], data -> data.split("-")[1]);

        single.subscribe(map->Logger.log(LogType.ON_NEXT, map));
    }
}
