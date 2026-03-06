package com.example.rxjava.chapter10;

import com.example.rxjava.chapter09.SampleObservable;
import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertValueTest {
    @Test
    public void assertValueTest(){
        Observable.just("a")
                .test()
                .assertValue("a");
    }

    @Test
    public void getCarMakerAssertValueTest(){
        SampleObservable.getCarMakerStream()
                .filter(CarMaker.SAMSUNG::equals)
                .test()
                .awaitDone(1L,TimeUnit.MILLISECONDS)    //쓰레드를 computation에서 발행하므로 잠시 대기하도록 한다.
                .assertValue(CarMaker.SAMSUNG);
    }
}
