package com.example.rxjava.chapter10;

import com.example.rxjava.chapter09.SampleObservable;
import com.example.rxjava.common.Car;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertEmptyTest {
    //해당 시점까지 통지된 데이터가 있는지 검증한다(error, complete, subscribe등 전부 어떤 이벤트도 통지되면 안됨)
    @Test
    public void getCarStreamEmptyFailTest(){
        //when
        Observable<Car> observable = SampleObservable.getCarStream();
        TestObserver<Car> observer = observable.test();

        //then
        observer.awaitDone(100L, TimeUnit.MILLISECONDS).assertEmpty();
    }

    @Test
    public void getCarStreamEmptySuccessTesT(){
        //when
        Observable<Car> observable = SampleObservable.getCarStream();
        TestObserver<Car> observer = observable.delay(1000L, TimeUnit.MILLISECONDS).test();

        //then
        observer.awaitDone(100L, TimeUnit.MILLISECONDS).assertEmpty();
    }
}
