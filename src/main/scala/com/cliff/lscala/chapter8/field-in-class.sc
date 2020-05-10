class Name1(var value: String)

class Name2(s: String) {
  private var _value: String = s

  // get方法
  def value: String = _value

  /**
   * 以下"_="结尾的方法，在调用时编译器允许去掉下划线，转而使用中缀表达式。
   */

  // set方法
  def value_=(newValue: String): Unit = {
    _value = newValue
  }


  override def toString: String = s"value:$s"
}

val name1 = new Name1("HelloWorld")
val name2 = new Name2("HelloWorld")

name1.value
name2.value = "Fuck"

class Name3(s:String){
  var value = s
}

val name3 = new Name3("Buck")
name3.value
name3.value = "Fuck"
name3.value
