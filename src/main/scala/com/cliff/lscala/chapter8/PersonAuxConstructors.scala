package com.cliff.lscala.chapter8

/**
 * Scala 中 构造函数有三种
 * 1. 类参数
 * 2. this函数
 * 3. object类中的apply方法
 */
case class Address(street: String, city: String, state: String, zip: String) {
  /**
   * this函数为次级构造器
   *
   * @param zip
   */
  def this(zip: String) =
    this("unknown", Address.zipToCity(zip), Address.zipToState(zip), zip)
}

object Address {
  def zipToCity(zip: String) = "AnyTown"

  def zipToState(zip: String) = "CA"
}

/**
 * 在case class 中
 * 类的声明参数，为主构造函数的参数
 *
 * @param name
 * @param age
 * @param address
 */
case class Person5(name: String,
                  age: Option[Int],
                  address: Option[Address]) {
  def this(name: String) = this(name, None, None)

  def this(name: String, age: Int) = this(name, Some(age), None)

  def this(name: String, address: Address) = this(name, None, Some(address))

  def this(name: String, age: Int, address: Address) = this(name, Some(age), Some(address))
}

case class Person2(name: String,
                   age: Option[Int] = None,
                   address: Option[Address] = None)

/**
 * case class 和与之对应的 伴生类 object class
 * @param name
 * @param age
 * @param address
 */
case class Person3(name: String,
                   age: Option[Int] = None,
                   address: Option[Address] = None)

/**
 * 与构造器不同，apply重载的是普通方法，因此apply必须有返回类型
 */
object Person3 {
  def apply(name: String, age: Int, address: Address): Person3 = new Person3(name, Some(age), Some(address))

  def apply(name: String): Person3 = new Person3(name)

  def apply(name: String, age: Int): Person3 = new Person3(name, Some(age))

  def apply(name: String, address: Address): Person3 = new Person3(name, address = Some(address))

}