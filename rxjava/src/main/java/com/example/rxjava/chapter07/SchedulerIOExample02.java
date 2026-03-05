package com.example.rxjava.chapter07;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample02 {
    public static void main(String[] args){
        File[] files = new File("src/main/java/com/example/rxjava").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getName()))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(File::isDirectory)
                .map(File::getName)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
