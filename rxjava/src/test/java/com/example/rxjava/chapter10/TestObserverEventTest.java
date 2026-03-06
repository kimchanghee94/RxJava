package com.example.rxjava.chapter10;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestObserverEventTest {
    @Test
    public void isterminalEventTest(){
        boolean result = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitCount(5)
                .isTerminated();    //완료 통지 이벤트가 발생해서 종료되었는가

        assertThat(result, is(true));
    }

    @Test
    public void isErrorEventTest(){
        boolean result = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .map(data -> {
                    if(data == 2) throw new RuntimeException("Error happened");
                    return data;
                })
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .awaitCount(5)
                .isTerminated();    //에러통지 이벤트가 발생하면서 종료되었는가

        assertThat(result, is(true));
    }
}