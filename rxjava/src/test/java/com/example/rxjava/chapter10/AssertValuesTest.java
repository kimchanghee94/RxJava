package com.example.rxjava.chapter10;

import com.example.rxjava.chapter09.SampleObservable;
import com.example.rxjava.common.CarMaker;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertValuesTest {

    @Test
    public void getCarMakerAssertValuesTest(){
        //assertValues는 1개 이상의 값을 검증할 사용!
        SampleObservable.getDuplicatedCarMakerStream()
                .filter(CarMaker.SAMSUNG::equals)
                .test()
                .awaitDone(1L,TimeUnit.MILLISECONDS)    //쓰레드를 computation에서 발행하므로 잠시 대기하도록 한다.
                .assertValues(CarMaker.SAMSUNG);
    }
}
