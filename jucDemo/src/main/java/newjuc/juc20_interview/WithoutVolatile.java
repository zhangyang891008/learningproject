package newjuc.juc20_interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 淘宝面试题：实现一个容器，提供add size方法，
 * 两个线程，一个添加10个元素到容器中，一个监控元素的个数，如果到达5个元素，线程输出提示
 */
public class WithoutVolatile {

    static List<String> list = new ArrayList<>();

    public void add(String val){
        list.add(val);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        WithoutVolatile v = new WithoutVolatile();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        v.add("thread"+i);
                        System.out.println("add--" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("monitor running...");
                while(true){
                    if(v.size()==5){
                        break;
                    }
                }
                System.out.println("I catch 5");
            }
        }).start();

    }
}
