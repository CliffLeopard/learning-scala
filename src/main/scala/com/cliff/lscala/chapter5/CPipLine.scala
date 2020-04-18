package com.cliff.lscala.chapter5

/**
 * 这是一种非常巧妙的实现PipeLine的方式
 * 隐式类Piped，自动产生了隐式类型转换函数，此函数遇到了"Hello World"则以"Hello World"为参数自动产生了一个Piped实例，遇到"|>"自动调用"|>"函数，
 * 此函数的参数是println函数，"|>"的函数实现是println函数调用构造函数的参数Hello World
 * 于是实现了将第一个表达式的值传递给第二个表达式的效果。
 */
object CPipLine {
  def main(args: Array[String]): Unit = {
    "Hello World" |> println
  }

  /**
   * 隐式类
   * 隐式类只能存在于Object，class,trait的内部
   * 隐式类不能为case class，切构造函数仅有一个参数
   * 对于一个隐式类，编译器会自动产生一个隐式类型转换函数，该函数会产生一个隐式类对象
   *
   * @param value
   * @tparam V
   */

  implicit class Piped[V](value: V) {
    def |>[R](f: V => R): R = f(value)
  }
}