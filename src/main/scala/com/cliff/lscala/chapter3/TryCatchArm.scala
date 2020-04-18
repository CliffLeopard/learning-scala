package com.cliff.lscala.chapter3

import scala.io.Source
import scala.util.control.NonFatal

object TryCatchArm {
  def main(args: Array[String]): Unit = {
    countLine("/Users/cliffleopard/Desktop/GH/LearningScala/src/main/resources/temp.txt")
    temp1(show)
    temp2(show)
  }

  def temp1(resource: => Unit): Unit = {
    resource
  }

  def temp2(resource: () => Unit): Unit = {
    resource()
  }

  def show() = {
    println("HelloWorld")
  }

  def countLine(fileName: String): Unit = {
    println
    manage(Source.fromFile(fileName)) { source =>
      val size = source.getLines().size
      println(s"file: $fileName  size:$size")
      if (size > 1) throw new RuntimeException("Big File")
    }
  }
}

/**
 * 这里manage使用小写，是因为在使用上manage更像一个方法
 * resource: => R 传名参数，实际上是resource = ()=> R的缩写,resource是一个无参函数。
 */
object manage {
  def apply[R <: {def close(): Unit}, T](resource: => R)(f: R => T) = {
    var res: Option[R] = None
    try {
      res = Some(resource)
      f(res.get)
    } catch {
      case NonFatal(ex) => println(s"NonFatal:$ex")
    } finally {
      for (s <- res) {
        println(s"Closing resource")
        s.close()
      }
    }
  }
}
