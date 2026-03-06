package com.example.rxjava.chapter09;

import com.example.rxjava.common.Car;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//BlockingLast를 사용해서 통지된 마지막 데이터를 테스트하는 예제
public class BlockingLastTest {
    @Test
    public void getCarStreamLastTest(){
        //when
        Car car = SampleObservable.getCarStream().blockingLast();
        String actual = car.getCarName();

        //then
        assertThat(actual, is("SM5"));
    }

    @Test
    public void getSalesOfBranchALastTest(){
        //when
        int actual = SampleObservable.getSalesOfBranchA()
                .take(6)
                .blockingLast();

        //then
        assertThat(actual, is(40_000_000));
    }
}
