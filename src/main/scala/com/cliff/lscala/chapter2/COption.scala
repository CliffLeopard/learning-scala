package com.cliff.lscala.chapter2

/**
 * Scala方法的各种调用方式
 * 元组字面量的表示方式(A,B,C),如果元组中有且只有两个元素，则又称为Pair，可用(A,B)或A->B
 * Map中存储的就是一个个Pair
 */
object COption {
  def main(args: Array[String]): Unit = {
    val aMap = Map(
      "A" -> "Hello",
      "B" -> "World",
      ("C", "Fuck"),
      "D" -> "OK"
    )

    println(aMap.get("A"))
    println(aMap("B"))
    println(
      aMap.getOrElse("E", {
        println("FUCK EveryBody")
        "New World"
      })
    )

    println {
      println("HaHaHa")
      "Fuck You"
    }

    println("GOOD")
  }
}
