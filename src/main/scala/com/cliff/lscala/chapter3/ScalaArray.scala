package com.cliff.lscala.chapter3

object ScalaArray {
  def main(args: Array[String]): Unit = {
    declaration()
    println
    betweenArray()
  }

  /**
    * 声明和基本操作
    */
  def declaration(): Unit = {
    val numbers = Array(1, 2, 3, 4, 5)
    val first = numbers(0)
    numbers(3) = 10
    println(first)
    numbers foreach print
    numbers map (_ * 2) foreach println
  }

  def betweenArray(): Unit = {
    val a = Array(1, 2)
    val b = Array(3, 4)
    val c = a ++ b
    c foreach print

    println

    val d = List(5, 6)
    val e = scala.collection.mutable.MutableList(7, 8)
    val f = e ++: d

    println(f.getClass.getName)
    println((e :: d).getClass().getName)

  }
}
