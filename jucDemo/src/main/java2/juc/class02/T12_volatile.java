package juc.class02;

public class T12_volatile {

    boolean running =  true;

    public void m(){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end");
    }


    public static void main(String[] args) {

    }
}
