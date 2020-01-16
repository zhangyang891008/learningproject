package com.ds;

public class Transfer {
    public static void main(String[] args) {
        Object s = Long.valueOf(111111);
        s = ((Long)s).intValue();
        if(s instanceof  Long){
            System.out.println("long");
        }
        if(s instanceof Integer)
            System.out.println("int");
    }
}
