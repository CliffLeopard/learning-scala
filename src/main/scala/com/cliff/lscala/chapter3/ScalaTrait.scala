package com.cliff.lscala.chapter3

object ScalaTrait {
  def main(args: Array[String]): Unit = {
    val serviceImportance = new ServiceImportance("haha")
    1 to 3 foreach (a => println(serviceImportance.work(a)))

    val serviceImportance2 = new ServiceImportance("Fuck") with StdOutLogging {
      override def work(i: Int): Int = {
        info(s"Staring work $i")
        val result = super.work(i)
        info(s"Ending work $i")
        result
      }
    }

    1 to 3 foreach (a => println(serviceImportance2.work(a)))
  }
}

class ServiceImportance(name: String) {
  def work(i: Int): Int = {
    println(s"ServiceImportance: Doing Important work: $i")
    i + 1
  }
}

trait Logging {

  def info(message: String): Unit

  def warnings(message: String): Unit

  def error(message: String): Unit

}

trait StdOutLogging extends Logging {
  override def info(message: String): Unit = println(s"info: $message")

  override def warnings(message: String): Unit = println(s"warnings: $message")

  override def error(message: String): Unit = println(s"error: $message")
}