package com.cliff.lscala.chapter2

object Semicolon {
  def main(args: Array[String]): Unit = {

    //    var val
    val array: Array[String] =
      new Array(5)
    val array2: Array[Double] = new Array(3)
    array2(1) = 12.5;
    array2.foreach(println)
    var p = new Person("cliff", 19)
    println(p)

    //    Range
    1 to 5 foreach (print)
    println()
    1 until 5 foreach (print)
    println()
    1 to 10 by 3 foreach (print)
    println()
    1L to 10L by 3 foreach (print)
    println()
    'a' to 'z' by 3 foreach (print)

    // 偏函数
    val pf1: PartialFunction[Any, String] = {
      case _: String => "YES"
      case _: Double => "NO"
    }


  }
}

class Person(name: String, age: Int)
