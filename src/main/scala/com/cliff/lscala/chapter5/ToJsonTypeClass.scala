package com.cliff.lscala.chapter5


case class Person(name: String, address: Address)

case class Address(street: String, city: String)

/**
 * 通过隐式类型转换完成类型类模式（type class pattern）
 * 类型类:通过静态编程实现元编程的方法，称为类型类
 * 类型类可以实现扩展方法，这种实现方式称为特设多态。
 *
 * 多态的类型有:子类型多态，参数化多态，特设多态。
 */
trait ToJSON {
  def toJSON(level: Int = 0): String

  val INDENTATION = "    "

  def indentation(level: Int = 0): (String, String) = INDENTATION * level -> INDENTATION * (level + 1)
}

object MyInterpolator {

  implicit class AddressToJSON(address: Address) extends ToJSON {
    override def toJSON(level: Int = 0): String = {
      val (out, in) = indentation(level)
      s"""{
         |$in"street:"${address.street},
         |$in"city:"${address.city}
         |$out}""".stripMargin

    }
  }

  implicit class PersonToJSON(person: Person) extends ToJSON {
    override def toJSON(level: Int): String = {
      val (out, in) = indentation(level)
      s"""{
         |$in"name:"${person.name},
         |$in"address:"${person.address.toJSON(level + 1)}
         |$out}""".stripMargin
    }
  }

  /**
   * 这里添加任意多的ToJSON隐式类型实现类式，就可以实现任意类型的对象都可以具有ToJSON的方法
   * 隐式类用于实现隐式类型转换，转化为隐式类的类型。隐式类型转换完成之后，就可以使用ToJSON方法
   */

}


object ToJsonTypeClass {

  import MyInterpolator._

  def main(args: Array[String]): Unit = {
    val address = new Address("八里庄", "北京")
    val person = new Person("cliff", address)

    println(address.toJSON())
    //    println(address.toJSON(2))
    println(person.toJSON())
    //    println(person.toJSON(4))
  }

}
