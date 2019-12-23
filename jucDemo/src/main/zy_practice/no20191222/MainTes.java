package no20191222;

import java.util.Date;

public class MainTes {
    public static void main(String[] args) {
        MyPair myPair = new MyPair();
        Pair pair = myPair;
        pair.setFirst(new Date());

        pair.getFirst();
    }
}
