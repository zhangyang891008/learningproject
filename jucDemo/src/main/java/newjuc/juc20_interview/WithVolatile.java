package newjuc.juc20_interview;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 淘宝面试题：实现一个容器，提供add size方法，
 * 两个线程，一个添加10个元素到容器中，一个监控元素的个数，如果到达5个元素，线程输出提示
 *
 * Collections.synchronized包装后的容器具有原子性，但是当线程判断出元素为5个以后，另外的线程继续添加，因此if判断的方式会有延迟。
 * @TODO 用volatile修饰能够具有可见性，但是修饰容器并不会让容器中的属性具有可见性，目前解释不了这个现象。
 *
 */
public class WithVolatile {

    static /*volatile */ List<String> list = Collections.synchronizedList(new LinkedList<>());

    public void add(String val){
        list.add(val);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        WithVolatile v = new WithVolatile();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                     v.add("thread"+i);
                    System.out.println("add--"+i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("monitor running...");
                while(true){
                    if(v.size() == 5){
                        System.out.println("I catch 5");
                        break;
                    }
                }
            }
        }).start();

    }
}
