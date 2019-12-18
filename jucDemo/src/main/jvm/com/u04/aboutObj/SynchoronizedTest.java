package com.u04.aboutObj;

public class SynchoronizedTest {

    public void m(){
        /*
        synchronized (SynchoronizedTest.class){
            int a = 9;
        }
         */

        try{
            int c = 111;
        }catch (Exception e){
            int b = 888;
        }finally {
            int e = 777;
        }

        int a = 999;
    }

    public static void main(String[] args) {

    }
}
