package com.cliff.lscala.chapter2

object StringUtilV1 {
  def joiner(strings: String*): String = strings.mkString(",")

  def joiner(strings: List[String]): String = joiner(strings: _*)  // 将列表转化为可变参数列表 _* _是进行类型推断的，不可以写成String*

  def main(args: Array[String]): Unit = {
    println(StringUtilV1.joiner("a", "b", "c"))
    println(StringUtilV1.joiner(List[String]("cd", "ef", "kk")))
  }

}
