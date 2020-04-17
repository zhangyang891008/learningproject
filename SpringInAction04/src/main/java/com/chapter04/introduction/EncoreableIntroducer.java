package com.chapter04.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    //value中“com.chapter04.introduction.IPerformance+”表示IPerformance的子类型，不包括本身
    @DeclareParents(value = "com.chapter04.introduction.IPerformance+",
    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
