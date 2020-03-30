package com.cliff.lscala.chapter1

import akka.actor.Actor

class ShapesDrawingActor extends Actor {

  import Messages._

//  这里使用了模式匹配和子类型多态技术
  override def receive: Receive = {
    case s: Shape =>
      s.draw(str => println(s"ShapesDrawingActor: $str"))
      sender ! Response(s"ShapesDrawingActor: $s drawn")
    case Exit =>
      println(s"ShapesDrawingActor: exiting...")
      sender ! Finished
    case unexpected =>
      val response = Response(s"ERROR: Unknown message: $unexpected")
      println(s"ShapesDrawingActor: $response")
      sender ! response
  }

}

object Messages {

  object Exit

  object Finished

  case class Response(message: String)

}