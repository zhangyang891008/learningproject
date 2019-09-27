package com.scala.function

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 控制流语句功能测试
 */
object forTest {

  def main(args: Array[String]): Unit = {
    //1.打印九九乘法表
    var row = 9;
    for (i <- 1 to 9){
      for (j <-1 to 9){
        if(j<=i)
        print(s"$i * $j = ${i*j} \t")
      }
      println()
    }
    //1.1 打印九九乘法表简洁版
    var count:Int = 0
    for (i <-1 to 9; j <-1 to 9){
      count +=1
      if(j<=i){
        print(s"$i * $j = ${i*j} \t")
      }
      if(j==i)
        println()
    }
    println(s"count : $count")

    //1.2 打印九九乘法表，带有截断功能的
    var count2:Int = 0
    for (i <-1 to 9; j <-1 to 9 if(i>=j)){
      count2 +=1
      if(j<=i){
        print(s"$i * $j = ${i*j} \t")
      }
      if(j==i)
        println()
    }
    println(s"count2 : $count2")

    //2打印集合中的内容
    var list = List("tom","jerry","lucy");
    for (i <- list){
      println(i)
    }

    //3定长数组
    var array = Array("a","b","c")
    var array2 = new Array[String](4)
    array2(0) = "ab";
    array2(1) = "abc";
    array2(2) = "abcd"
    array2(3) = "abcde"
    for(i <- array2){
      println(i)
    }
    //3.1求最大
    val max = Array(1,2,3).max
    println("array max:" + max)
    var max2 = Array("c","a","c").max
    println("char max:" + max2)

    //3.2求和
    var sum = Array(1,2,3,4,5,6).sum
    println("sum " + sum)

    //4map
    var map = new mutable.HashMap[String, Int]()
    map.put("zhangyang",22)
    map.put("maguangpang",33)
    for (i <- map.keySet.toArray){
      println(s"$i, ${map.get(i)}")  //zhangyang, Some(22)
    }
    for((k,v) <- map){
      println(s"$k, $v")
    }
    //4.1直接赋值
    var map2 = mutable.HashMap("key1"->"value1","key2"->"value2")
    for((k,v) <- map2){
      println(s"$k, $v")
    }

    //5buffer
    val buf = ArrayBuffer[Int]()
    buf += 1
    buf += (2,3,4)
    buf.append(2,3,45)
    println("buffer size:" + buf.size)
    for (elem <- buf) {
      println(elem)
    }

    //6元组
    var tuple = (1,"hi" ,5 , "bye", 6)
  }
}
