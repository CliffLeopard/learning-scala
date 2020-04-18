package com.cliff.lscala.chapter3

import scala.io.Source
import scala.util.control.NonFatal

object TryCatch {
  def main(args: Array[String]): Unit = {
    countLines("/Users/cliffleopard/Desktop/GH/LearningScala/src/main/resources/temp.txt")
  }

  def countLines(fileName: String): Unit = {
    println
    var source: Option[Source] = None
    try {
      source = Some(Source.fromFile(fileName))
      val size = source.get.getLines.size
      println(s"file $fileName has size: $size")
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception: $ex")
    } finally {
      for (s <- source) {
        println(s"Closing $fileName")
        s.close()
      }
    }
  }


}
