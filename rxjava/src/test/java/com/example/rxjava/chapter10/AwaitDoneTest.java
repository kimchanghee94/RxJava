package com.example.rxjava.chapter10;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AwaitDoneTest {
    @Test
    public void awaitDoneTest01(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitDone(500L, TimeUnit.MILLISECONDS) //그냥 assert와 달리 얘는 완료통지 필요없음
                .assertNotComplete()    //완료 통지가 없는지
                .assertValueCount(2);   //총 통지된 갯수
    }

    @Test
    public void awaitDoneTest02(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitDone(1500L, TimeUnit.MILLISECONDS)
                .assertComplete()       //완료 통지가 있는지
                .assertValueCount(5);   //총 통지된 개수
    }
}