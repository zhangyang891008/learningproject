package com.zy.spring;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
1注解方式
 */
@Component
@Aspect
public class LogUtil {

    @Before(value = "execution(* *(..))")
    public void before(){
        System.out.println("Before method");
    }
    @After(value="execution(* *(..))")
    public void after(){
        System.out.println("after method");
    }

    @AfterReturning(value = "execution(* *(..))")
    public void afterReturning(){
        System.out.println("after returning");
    }

    //当前过滤条件只有Calculate类的divide()方法可以生效&& execution(* com.zy.spring.Calculate.divide(..))
    @AfterThrowing(value= "execution(* *(..) )",throwing="ex")
    public void afterThrowing(Throwable ex){
        System.out.println("after throwing"+ex);
    }
}
