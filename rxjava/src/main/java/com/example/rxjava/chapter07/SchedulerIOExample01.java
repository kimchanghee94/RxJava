package com.example.rxjava.chapter07;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class SchedulerIOExample01 {
    public static void main(String[] args){
        File[] files = new File("src/main/java/com/example/rxjava").listFiles();

        Observable.fromArray(files)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getName()))
                .filter(data -> data.isDirectory())
                .map(dir -> dir.getName())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
