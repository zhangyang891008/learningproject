package no20200114;

import java.util.ArrayList;
import java.util.Collections;

/*
java核心思想 chapter17
填充容器
Collections.nCopies(n,Object)
Collections.fill(list,Object)
 */
public class FillingLists {
    public static void main(String[] args) {
        ArrayList<StringAddress> address = new ArrayList<StringAddress>(
                Collections.nCopies(4,new StringAddress("my address")));
        System.out.println(address);
        address.add(new StringAddress("add again"));
        Collections.fill(address,new StringAddress("after"));
        System.out.println(address);
    }

}

class StringAddress{
    private String s;
    public StringAddress(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "StringAddress{" +
                "s='" + s + '\'' +
                '}';
    }
}