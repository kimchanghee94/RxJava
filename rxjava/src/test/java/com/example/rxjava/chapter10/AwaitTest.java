package com.example.rxjava.chapter10;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class AwaitTest {
    @Test
    public void awaitTest() throws InterruptedException{
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .await()    //생산자쪽에서 완료 통지를 보낼때까지 대기한 후, 완료 및 통지된 데이터 개수를 검증한다
                .assertComplete()
                .assertValueCount(5);
    }

    @Test
    public void awaitTest02() throws InterruptedException{
        //지정한 시간동안 대기하면서 대기 시간내에 완료 통지를 받았는지 여부 검증
        boolean result = Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                .test()
                .await(2000L, TimeUnit.MILLISECONDS);

        assertThat(result, is(false));
    }
}