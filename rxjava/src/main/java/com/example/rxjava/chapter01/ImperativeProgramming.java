package com.example.rxjava.chapter01;

import java.util.Arrays;
import java.util.List;

public class ImperativeProgramming {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,3,21,10,8,11);
        int sum = numbers.stream().filter(n->n>6 && n%2!=0)
                .mapToInt(n->n).sum();

        System.out.println("# 선언형 프로그래밍 사용: " + sum);
    }
}
