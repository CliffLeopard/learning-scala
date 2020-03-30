package com.cliff.lscala.chapter2

/**
 * 展示多参数列表
 * 多参数列表中，参数两边的圆括号可以修改为花括号
 */
object Shape2 {
  def main(args: Array[String]): Unit = {
    val circle = Circle(Point(), 12.4)
    val rectangle = Rectangle(Point(), Point(), Point())
    circle.draw(Point(1.2, 3.1))(println)

    //    优势1:可以使用花括号替代圆括号，使代码有整齐的语法结构
    rectangle.draw(Point(1.0, 2.0)) {
      println
    }

    rectangle.draw {
      Point(1.2, 3.0)
    }(println)

    rectangle.draw {
      Point(1.2, 3.0)
    } {
      println
    }


    //    使用缺省的偏移量，第一个圆括号不能省略
    rectangle.draw()(println)
    //    最后一个可以省略,zz变成一个未应用的函数
    val zz = rectangle.draw(Point(1.0, 2.0)) _
    zz(println)


    //    优势2:可以使用前面的参数列表，推断后面的参数列表中的参数的类型
    def m1[A](a: A, f: A => String) = f(a)

    def m2[A](a: A)(f: A => String) = f(a)

    //    m1(100,i =>s"$i +$i")  这样写就错了
    m2(100)(i => s"$i +$i")

    //    优势3:使用最后一个参数列表来推断隐含参数，例如Future


  }
}


abstract class Shape2 {

  def draw(offset: Point = Point())(f: String => Unit = println): Unit = {
    f(s"draw(offset = $offset),$this")
  }
}

case class Point(x: Double = 0.0, y: Double = 0.0)

case class Circle(point: Point, radius: Double = 0.0) extends Shape2

case class Rectangle(point1: Point, point2: Point, point3: Point) extends Shape2