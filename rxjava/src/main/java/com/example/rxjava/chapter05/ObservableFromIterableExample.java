package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {
    public static void main(String[] args) throws InterruptedException{
        List<String> countries = Arrays.asList("Korea", "Canada", "USA", "Italy");
        Observable.fromIterable(countries).subscribe(country->Logger.log(LogType.ON_NEXT, country));
    }
}
