package no20200120.thissuper;

import java.util.ArrayList;
import java.util.Collections;

/*
码出高效：chapter2：super & this
 */
public class ThisSuperTest {

    public static void main(String[] args) {
        Father father = new Son();
        father.doSomething();
    }

}

class Father{
    protected void doSomething(){
        System.out.println("father dosomething...");
        this.doSomething();
    }
}

class Son extends Father{
    public void doSomething(){
        System.out.println("son dosomething...");
        //super.doSomething();
    }
}