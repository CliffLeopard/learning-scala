package com.cliff.lscala.chapter7

import scala.io.Source

/**
 * for推到式
 * for推到式组成：
 *  1. 一个或多个生成器表达式
 *  2. 可选的保护表达式
 */
object RemoveBlanks {
  def apply(path: String, compressWithSpace: Boolean = false): Seq[String] = for {
    // <-表示生成器表达式,这里文件流没有关闭，暂且不管
    line <- Source.fromFile(getClass.getClassLoader.getResource(path).getFile).getLines.toSeq
    //  这是一个保护式
    if !line.matches("""^\s*$""")
    line2 =
    if (compressWithSpace) line replaceAll("\\s+", " ")
    else line

  } yield line2

  def main(args: Array[String]): Unit = {
    val fileNames = Array[String]("-temp.txt", "temp2.txt", "temp3.txt")
    for {
      path2 <- fileNames // 生成器表达式必须作为for推到式的第一条语句
      (compress, path) = if (path2 startsWith "-") (true, path2.substring(1)) else (false, path2)
      line <- apply(path, compress) // 生成器表达式也必须作为for推到式的最后一条语句
    } println(line)
  }
}
