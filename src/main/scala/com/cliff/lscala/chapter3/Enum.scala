package com.cliff.lscala.chapter3

/**
 * Scala枚举类型
 */
object Enum extends Enumeration {
  type Enum = Value
  val a = Value("ABC")
  val b = Value("CDE")
  val c = Value("ACD")
  val d = Value("AKF")

  def main(args: Array[String]): Unit = {
    for(bread <- Enum.values) println(s"${bread.id} \t  ${bread.getClass().getName}   \t  $bread")
  }
}
