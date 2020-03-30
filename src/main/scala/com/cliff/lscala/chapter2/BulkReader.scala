package com.cliff.lscala.chapter2

import java.io.{BufferedInputStream, File, FileInputStream}


/**
 * 此类用来比价类型成员和参数化类型
 */

/**
 * 类型成员
 * 这里必须使用abstract类型，因为1.定义类类型成员In,2:声明了函数read而并没有实现
 */
abstract class BulkReader {
  type In
  val source: In

  def read: String
}

class StringBulkReader(val source: String) extends BulkReader {
  type In = String

  override def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader {
  type In = File

  override def read: String = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes)
    new String(bytes)
  }
}

object BulkReader {
  def main(args: Array[String]): Unit = {
    println(new StringBulkReader("Hello World").read)
    println(new FileBulkReader(new File("/Users/cliffleopard/Desktop/GH/LearningScala/src/main/resources/temp.txt")).read)
  }
}