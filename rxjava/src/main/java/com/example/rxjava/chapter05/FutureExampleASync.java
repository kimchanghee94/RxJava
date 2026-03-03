package com.example.rxjava.chapter05;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;

import java.util.concurrent.Future;

public class FutureExampleASync {
    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();

        CarRepairShop shop = new CarRepairShop();

        Future<Integer> future = shop.getCarRepairCostAsync(10);

        requestSickLeave("20170903-01");

        requestInsurance("44나4444");

        try{
            int carRepairCost = future.get();
            Logger.log(LogType.PRINT, "# (1) 차량 수리비 계산이 완료되었습니다.");
            Logger.log(LogType.PRINT, "# 차량 수리비는 " + carRepairCost + "원 입니다.");
        }catch (Exception e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        double executeTime = (endTime-startTime)/1000.0;
        System.out.println();
        System.out.println("# 처리 시간: "+ executeTime+ "초");
    }

    private static void requestSickLeave(String empNumber){
        try{
            Thread.sleep(1000);
            Logger.log(LogType.PRINT, "#(2) 병가 신청 완료");
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }

    private static void requestInsurance(String carNumber){
        try{
            Thread.sleep(1000);
            Logger.log(LogType.PRINT,"#(3) 보험 신청 완료");
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
