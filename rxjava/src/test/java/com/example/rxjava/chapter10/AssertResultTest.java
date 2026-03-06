package com.example.rxjava.chapter10;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertResultTest {
    @Test
    public void assertResultFailTest(){
        //무한히 데이터를 통지하게 되는데 complete통지가 안됌, 그래서 통지가 모두 돼야 assertResult로 측정 가능
        //즉, assertValues와 다르게 얘는 통지 완료가 이뤄줘야만한다!
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .filter(data -> data>3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }

    @Test
    public void assertResultSuccessTest(){
        Observable.interval(200L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .take(5)
                .filter(data -> data>3)
                .test()
                .awaitDone(1100L, TimeUnit.MILLISECONDS)
                .assertResult(4L);
    }
}
