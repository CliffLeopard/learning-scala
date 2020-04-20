package com.cliff.lscala.chapter6

/**
 * 尾递归的trampoline优化
 *
 * 函数在isEven和isOdd之间来回跳转，最后落在isEven则为奇数，否则为偶数
 * isEven和isOdd返回值都是尾递归函数
 */
object Recursion {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      val even = isEven((1 to i).toList).result
      println(s"$i is even? $even")
    }
  }

  import scala.util.control.TailCalls._

  def isEven(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(isOdd(xs.tail))

  def isOdd(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(isEven(xs.tail))
}
