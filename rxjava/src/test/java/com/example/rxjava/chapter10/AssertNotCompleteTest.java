package com.example.rxjava.chapter10;

import com.example.rxjava.chapter09.SampleObservable;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class AssertNotCompleteTest {
    @Test
    public void assertNotCompleteTest(){
        SampleObservable.getSalesOfBranchA()
                .zipWith(SampleObservable.getSalesOfBranchB(),
                        (a,b) -> {
                            TimeUtil.sleep(1000L);
                            return a+b;
                        })
                .test()
                .awaitDone(3000L,TimeUnit.MILLISECONDS)
                .assertNotComplete();
    }
}