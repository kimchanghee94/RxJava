package com.example.rxjava.chapter07;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample03 {
    public static void main(String[] args){
        File[] files = new File("src/main/java/com/example/rxjava").listFiles();

        Observable.fromArray(files)
                        .doOnNext(file -> Logger.log(LogType.DO_ON_NEXT, "# 데이터 통지"))
                        .subscribeOn(Schedulers.io())

                        .observeOn(Schedulers.computation())
                        .filter(File::isDirectory)
                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# filter() 거침"))

                        .observeOn(Schedulers.computation())
                        .map(File::getName)
                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# map() 거침"))

                        .observeOn(Schedulers.computation())
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
