//import scala.{specialized => sp}
class Wrapper[@specialized(Short, Int, Long, Float, Double) A](unwrap: A)

new Wrapper[Short](42)

new Wrapper[Int](42)

new Wrapper[Long](42L)

new Wrapper[Float](3.14f)

new Wrapper[Double](3.14)

new Wrapper[String]("hi")