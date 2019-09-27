package com.scala

object Student{
  var name:String="yy"
  var addr:String="neu"

  def apply() = {
    println("Object student apply is executing...")
  }

  def main(args: Array[String]): Unit = {
    var s = new Student()

  }
}

class Student{
  var name:String="zz"
  var addr:String="dongbei"

  def apply() = {
    println("Class student apply is executing...")
  }

  def say() = {
    println(s"Class:My name is ${name}, My addr is ${addr}")
  }
}