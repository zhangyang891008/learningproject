package com.scala

object VarTest {
  //字符串类型
  var mumber = "a"
  mumber = "b"
  mumber = mumber + "~tail"
  mumber = 1 + mumber
  //字符
  var char = 'a'
  //整型
  var sum = 1
 // sum += 2 + "111"  //类型检查没有发现

  def calculate(a:Int, b:Int): Int = {
    var c = a + b
    return c
  }

  def combine(str1:String, str2:String): String = {
    return str1 + str2
  }

  def split(str:String): Array[String] = {
    val strings = str.split(",")
    return strings
  }

  def main(args: Array[String]): Unit = {
    println(char)
    println(mumber)
    println(sum)
    // 加法计算
    var ret = calculate(4,5)
    println(ret)
    // 合并字符串
    var com = combine("hello", "world")
    println(com)
    // 截取拆分
    val strings = split("a,b,c,d,e,f")
    for (elem <- strings.array) {
      println(elem)
    }
  }
}
