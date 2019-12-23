package no20191222;

import java.util.Date;

public class MyPair extends Pair<Date> {

    @Override
    public void setFirst(Date date) {
        System.out.println("running in myPair");
    }

    public Date getFirst(){
        System.out.println("running in myPair" + super.getFirst());
        return super.getFirst();
    }
}
