/**
 * 绕开类型擦除带来的限制
 */
object M {

  //   这里定义了两个新的类型
  implicit object IntMarker

  implicit object StringMarker

  def m(seq: Seq[Int])(implicit i: IntMarker.type) = println(s"Seq[Int]:$seq")

  def m(seq: Seq[String])(implicit i: StringMarker.type) = println(s"Seq[Int]:$seq")
}

import M._

m(List(1, 2, 3, 4))
m(List("One", "Two", "Three", "Four"))