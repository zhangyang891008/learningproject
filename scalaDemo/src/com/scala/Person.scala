package com.scala

/**
 *
 */
class Person (name:String, age:Int){

  //val name:String="lisi"
  //val age:Int=77
  def introduceMe = {
    println(s"Class:My name is ${name}, My age is ${age}")
  }
}

object Person{
  private var name = "zhangyang"
  private var age = 29

  def main(args: Array[String]): Unit = {
    println(s"Object:My name is $name, My age is $age")
    var p = new Person("zhangsan", 23)
    p.introduceMe
  }
}


