package com.cliff.lscala.chapter8

/**
 * Scala中定义类，构造参数前添加var，使得该参数为可变字段，加val则为不可变字段
 *
 * @param name
 * @param age
 */
class Person(var name: String, val age: Int) {

}

/**
 * case class 中自动为val，并且自动增加一些方法
 * case类，编译器自动生成一个伴随对象（object）
 * @param name
 * @param age
 */
case class ImmutablePerson(name: String, age: Int)


trait Foo {
  val x: Int

  def x(i: Int): Int  // 有参方法的定义可以与字段同名

  //  def x:Int   参数为空的方法不可以与字段重名
}

/**
 * Scala类型系统
 * AnyRef:所有引用类型的父类,类似于java中的Object。 使用New方法或者字面量语法进行创建。 在堆上创建
 * AnyVal：所有值类型的父类。Short,Int,Long,Float,Double,Boolean,Char,Byte,Unit. 只能用字面量创建，在寄存器或者栈中创建，
 * Any:AnyRef和AnyVal的父类
 */