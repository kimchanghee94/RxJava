package com.example.rxjava.chapter09;


import com.example.rxjava.common.CarMaker;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;



public class BlockingIterableTest {
    @Test
    public void getCarMakerIterableTest(){
        //when
        Iterable<CarMaker> iterable = SampleObservable.getCarMakerStream().blockingIterable();
        Iterator<CarMaker> iterator = iterable.iterator();

        //then
        assertThat(iterator.hasNext(), is(true));

        assertThat(iterator.next(), is(CarMaker.CHEVROLET));
        assertThat(iterator.next(), is(CarMaker.HYUNDAE));
        assertThat(iterator.next(), is(CarMaker.SAMSUNG));
        assertThat(iterator.next(), is(CarMaker.SSANGYOUNG));
        assertThat(iterator.next(), is(CarMaker.KIA));
    }


}
