package com.cliff.lscala.chapter1

abstract class Shape {
  def draw(f: String => Unit): Unit = f(s"draw:${this.toString}")
}

case class Point(x: Double = 0.0, y: Double = 0.0)

case class Circle(center: Point, radius: Double = 0.0) extends Shape

case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape

case class Rectangle(lowerLeft: Point,
                     height: Double = 0.0,
                     width: Double = 0.0) extends Shape
