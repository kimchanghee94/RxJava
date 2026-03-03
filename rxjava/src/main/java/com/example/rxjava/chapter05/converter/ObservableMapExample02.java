package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableMapExample02 {
    public static void main(String[] args){
        Observable.just("korea", "america", "canada", "paris", "japan", "china")
                .filter(country -> country.length()==5)
                .map(country -> country.toUpperCase().charAt(0) + country.substring(1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
