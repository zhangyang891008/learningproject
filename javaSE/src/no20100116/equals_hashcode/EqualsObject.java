package no20100116.equals_hashcode;

import java.util.HashSet;
import java.util.Set;

/**
 * equals & hashcode
 * 自定义对象的比较，要同时重写hashcode 和equals
 *
 */
public class EqualsObject {

    private Integer id ;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EqualsObject(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof EqualsObject){
            EqualsObject other = (EqualsObject)obj;
            return (this.name.equals(other.getName()) && this.id == other.getId()) ? true:false;
        }
        return false;
    }

    //由于EqualsObject只重写了equals方法，导致本应该相同的三个对象被保存了三次
    public static void main(String[] args) {
        Set<EqualsObject> set = new HashSet<>();

        set.add(new EqualsObject(1,"haha"));
        set.add(new EqualsObject(1,"haha"));
        set.add(new EqualsObject(1,"haha"));
        System.out.println(set.size());
    }

}
