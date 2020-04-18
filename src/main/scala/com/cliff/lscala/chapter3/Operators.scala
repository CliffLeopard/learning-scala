package com.cliff.lscala.chapter3

/**
 * 本文件来演示Scala中的各种类型的操作符，以及操作符重载
 */
object Operators {
  def main(args: Array[String]): Unit = {
    import scala.languageFeature.postfixOps

    // 在scala中一切皆为对象，即使java中的一些基础类型Int,Float,Double,Char,Long,Byte,Boolean等等都是对象，对象就有方法
    println(1 + 2)
    // 这里+就是Int的方法，
    // 由于是单参数方法，可以使用中缀表示法来表示单参数的方法。省略了.和()，实际当不省略时的写法如下:
    println(1.+(2));

    //当方法无参数时，同样也可以省略.和()  如Int类的toString()方法
    println(1.toString())
    println(1 toString)

    def isEven(n: Int) = n % 2 == 0

  }
}
