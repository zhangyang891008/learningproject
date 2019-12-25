package no20191223;

import java.util.ArrayList;
import java.util.List;

/*
    9。异常：
        泛型异常不能被catch捕获   catch(T t)
        可以抛出
 */
public class T09_Exception {

    public static void main(String[] args) {
        MyProcessor myProcessor = new MyProcessor();
        List<String> result = new ArrayList<>();
        try {
            myProcessor.process(result);
            myProcessor.process(result); //count <=0 触发异常
            myProcessor.process(result);
        } catch (Failure failure) {
            failure.printStackTrace();
        }
    }
}

interface Processor<T,E extends Exception>{
    void process(List<T> result) throws E;
}
class Failure extends Exception{}

class MyProcessor implements  Processor<String, Failure>{
    static int count = 2;
    @Override
    public void process(List<String> result) throws Failure {
        if(count > 0){
            result.add("add"+count);
            count--;
        }
        if(count <= 0)
            throw new Failure();
    }
}
