package com.example.rxjava.chapter01;

import java.util.Arrays;
import java.util.List;

public class DeclarativeProgramming {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,3,21,10,8,11);
        int sum=0;

        for(int num : numbers){
            if(num>6 && num%2!=0) sum+=num;
        }
        System.out.println("# 명령어 프로그래밍 사용 : " + sum);
    }
}
