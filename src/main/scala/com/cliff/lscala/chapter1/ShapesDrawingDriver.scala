package com.cliff.lscala.chapter1

import akka.actor.{Actor, ActorRef, ActorSystem, CoordinatedShutdown, Props}
import com.typesafe.config.ConfigFactory

private object Start


object ShapesDrawingDriver {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())
    val drawer = system.actorOf(
      Props(new ShapesDrawingActor), "drawingActor")
    val driver = system.actorOf(
      Props(new ShapesDrawingDriver(drawer)), "drawingService")
    driver ! Start
  }
}

class ShapesDrawingDriver(drawingActor: ActorRef) extends Actor {

  import Messages._

  CoordinatedShutdown(context.system).addJvmShutdownHook {
    println("custom JVM shutdown hook...")
  }
  override def receive: Receive = {
    case Start =>
      drawingActor ! Circle(Point(0.0, 1.0), 1.0)
      drawingActor ! Rectangle(Point(2.0,3.0),10.0,10.2)
      drawingActor ! Triangle(Point(2.0,3.0),Point(5.0,3.0),Point(12.0,4.0))
      drawingActor ! Exit
    case Finished =>
      println(s"ShapesDrawingDriver: cleaning up ...")
      context.system.terminate()
    case response: Response =>
      println(s"ShapesDrawingDriver: Response: $response")
    case unexpected =>
      println(s"ShapesDrawingDriver: ERROR: Received an unexpected message = $unexpected")
  }
}
