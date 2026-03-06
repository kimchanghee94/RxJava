package com.example.rxjava.chapter10;

import com.example.rxjava.chapter09.SampleObservable;
import com.example.rxjava.utils.TimeUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AssertCompleteTest {
    @Test
    public void assertCompleteTest(){
        SampleObservable.getSalesOfBranchA()
                .zipWith(SampleObservable.getSalesOfBranchB(),
                        (a,b) -> {
                            TimeUtil.sleep(100L);
                            return a+b;
                        })
                .test()
                .awaitDone(3000L,TimeUnit.MILLISECONDS)
                .assertComplete();
    }
}