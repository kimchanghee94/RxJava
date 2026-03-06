package com.example.rxjava.chapter09;

import com.example.rxjava.common.Car;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//BlockingFirst를 사용해서 통지된 첫번째 데이터를 테스트하는 예제
public class BlockingFirstTest {
    @Test
    public void getCarStreamFirstTest(){
        //when
        Car car = SampleObservable.getCarStream().blockingFirst();
        String actual = car.getCarName();

        //then
        assertThat(actual, is("말리부"));
    }

    @Test
    public void getSalesOfBranchAFirstTest(){
        //when
        int actual = SampleObservable.getSalesOfBranchA()
                .take(6)
                .blockingFirst();

        //then
        assertThat(actual, is(15_000_000));
    }
}
