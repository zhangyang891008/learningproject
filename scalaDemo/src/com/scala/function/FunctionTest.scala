package com.scala.function

import java.util.Date

object FunctionTest {

  def noArgMethod2() ={
    println("noArgMethod2...")
  }

  def noArgMethod3():Int ={
    return 5;
  }

  def main(args: Array[String]): Unit = {
    println("hello world!")

    //1.简单function
    def printArgs(arg:String)={
      println(s"printArgs: $arg")
    }
    printArgs("parameters")

    //2.无参数函数
    def noArgsMethod()={
        println("noArgsMethod...")
    }
    noArgsMethod  //无参数可以执行
    var noArgMe = noArgsMethod _// 方法名+空格+“_”

    //2.1 如果不使用 空格+“_” ，直接赋值给一个变量，那么在赋值过程中就会执行，再执行noArgMe02就没有任何效果了
    var noArgMe02 = noArgMethod2() //执行
    println(noArgMe02) //已经在上一步执行完了
    noArgMe02   //空

    //2.2如果无参方法有返回值，noArgMe03可以获取到返回值
    var noArgMe03 = noArgMethod3()  //方法已经执行了，noArgMe03接受到了返回结果
    println(noArgMe03)  //输出返回结果

    //3.函数的复用
    def log(date:Date, level:String, msg:String) ={
      println(s"date:$date, level:$level, msg:$msg")
    }

    log(new Date(), "debug", "stackoverFlow error")
    //3.1函数复用
    var mylog = log(_:Date, "error", _:String)
    mylog(new Date(), "outofMemory")

    //4.匿名函数
    var noName = (a:Int, b:Int) => { 5}
    var ret = noName(2,3)
    println(ret)

    //4.1匿名函数作为参数
    def MyFun(a:Int, b:Int,f:(Int,Int)=>{})={
        var ret = f(a,b)
        println("result :" + ret);
    }
        //传匿名参数
    MyFun(1,2,(a:Int,b:Int)=>a+b)

    //5.可变参数
    def paramFun(paras:Int*)={
      var sum = 0
      for (elem <- paras) {
        sum += elem
      }
      sum
    }
    println(paramFun(1,2,3,4,5,6,7,8,9))

    //6.柯里性
    def paramFun2(numbers:Int*)(strs:String*)={
      print("numbers----")
      for (elem <- numbers) {
        println(elem)
      }
      println("strs----")
      for (elem <- strs) {
        println(elem)
      }
    }
    paramFun2(1,2,3,4)("a","b","hello","world")

    //7.入参带有默认值的函数
    def defaultFun(key:String = "key", value:String = "value"): Unit ={
      println(s"$key , $value")
    }
    defaultFun("mykey") //缺省赋值
    defaultFun(value="myvalue") //只给第二个参数赋初始值的方法


  }
}
