package com.example.rxjava.chapter09;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlockingSubscribeTest {
    @Test
    public void avgTempOfSeoulTest(){
        //blockingSubscribe는 데이터를 처리후 새로 반환해서 검사를 한다는 점!
        Calculator calculator = new Calculator();

        SampleObservable.getSpeedOfSectionA()
                .blockingSubscribe(data -> calculator.setSum(data));

        assertThat(calculator.getSum(), is(615));
    }
}