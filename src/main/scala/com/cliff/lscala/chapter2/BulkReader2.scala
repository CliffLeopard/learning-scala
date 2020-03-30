package com.cliff.lscala.chapter2

import java.io.{BufferedInputStream, File, FileInputStream}

/**
 * 参数化类型
 * 参数化类型更喜欢用在类型参数与参数化的类型无关时，比如List[A],A可以是Int,String... A是什么与List[A]本身的行为无关
 *
 * @tparam In
 */
abstract class BulkReader2[In] {
  val source: In

  def read: String
}

class StringBulkReader2(val source: String) extends BulkReader2[String] {
  override def read: String = source
}

class FileBulkReader2(val source: File) extends BulkReader2[File] {
  override def read: String = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes)
    new String(bytes)
  }
}

object BulkReader2 {
  def main(args: Array[String]): Unit = {
    println(new StringBulkReader2("Hello World").read)
    println(new FileBulkReader2(new File("/Users/cliffleopard/Desktop/GH/LearningScala/src/main/resources/temp.txt")).read)
  }
}