/**
 * Scala 类中的一元操作符
 *
 * @param real
 * @param imag
 */

case class Complex(real: Double, imag: Double) {
  def unary_- = Complex(-real, -imag)

  def -(other: Complex) = Complex(real - other.real, imag - other.imag)

  def +(other: Complex) = Complex(real + other.real, imag + other.imag)
}

val c1 = Complex(1.1, 2.2)
val c2 = -c1
val c3 = c1.unary_-
val c4 = c1 - c2
val c5 = c1 + c2