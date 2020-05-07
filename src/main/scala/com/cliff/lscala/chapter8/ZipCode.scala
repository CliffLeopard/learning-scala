package com.cliff.lscala.chapter8

case class ZipCode(zip: Int, extension: Option[Int] = None) {
  require(valid(zip, extension), s"Invalid Zip+4 specified: $toString")

  protected def valid(z: Int, e: Option[Int]): Boolean = {
    if (0 < z && z < 99999) e match {
      case None => validUSPS(z, 0)
      case Some(e) => 0 < e && e <= 9999 && validUSPS(z, e)
    } else
      false
  }

  protected def validUSPS(i: Int, e: Int): Boolean = true

  override def toString: String = if (extension != None) s"$zip-${extension.get}" else zip.toString
}

object ZipCode {
  def apply(zip: Int, extension: Int): ZipCode = new ZipCode(zip, Some(extension))
}

object Main{
  def main(args: Array[String]): Unit = {
    println(ZipCode(12345))
    println(ZipCode(12345,Some(6789)))
    println(ZipCode(12345,6789))
  }
}