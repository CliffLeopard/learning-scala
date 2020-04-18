package com.cliff.lscala.chapter5

import scala.util.parsing.json._


/**
 * 构建自己的字符串插入器
 */
object Interpolator {

  implicit class JSonContext(sc: StringContext) {
    def json(values: Any*): JSONObject = {
      val keyRex = """^[\s{,]*(\s*\S+\s*):\s*""".r
      val keys = sc.parts map {
        case keyRex(key) =>
          key.trim()
        case str =>
          str
      }
      val kvs = keys zip values
      JSONObject(kvs.toMap)
    }
  }

}

object CStringContext {

  import Interpolator._

  def main(args: Array[String]): Unit = {
    val name = "Dean Wampler"
    val book = "Programming Scala, Second Edition"
    val jsonObj = json"  name   :  $name,book:$book"
    println(jsonObj)
  }

}

