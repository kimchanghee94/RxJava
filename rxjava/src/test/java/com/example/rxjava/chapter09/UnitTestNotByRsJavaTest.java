package com.example.rxjava.chapter09;

import com.example.rxjava.common.CarMaker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UnitTestNotByRsJavaTest {
    @Test
    public void getCarMakerStreamSyncTest(){
        //blocking을 이용하여 테스트를 해야되는 이유는 아래와 같이 비동기처리로 되면 결과값을 받아올수가 없다.
        List<CarMaker> carMakersList = new ArrayList<>();
        SampleObservable.getCarMakerStream()
                .subscribe(data -> carMakersList.add(data));
        assertThat(carMakersList.size(), is(5));
    }
}