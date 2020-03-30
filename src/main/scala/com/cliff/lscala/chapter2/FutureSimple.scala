package com.cliff.lscala.chapter2

import scala.concurrent.Future
import scala.util.{Failure, Success}


object FutureSimple {
  def main(args: Array[String]): Unit = {

    def sleep(millis: Long): Unit = {
      Thread.sleep(millis)
    }

    def doWork(index: Int) = {
      sleep((math.random * 1000).toLong)
      index
    }
    //    引用隐式参数
    import scala.concurrent.ExecutionContext.Implicits.global
    (1 to 5) foreach { index =>
      //      第一处使用隐形参数
      val future = Future {
        doWork(index)
      }
      //      第二处使用隐形参数
      future onSuccess {
        case answer: Int =>
          println(s"Success! returned: $answer")
      }
      //      第三处使用隐形参数
      future onFailure {
        case th: Throwable => println(s"Failure! returned: $th")
      }

      //      第四处引用隐式参数
      future onComplete {
        case Success(answer) =>
          println(s"Success! returned: $answer")
        case Failure(th: Throwable) =>
          println(s"Failure! returned: $th")
      }

    }
    sleep(1000)
    println("Finished!")


  }
}
