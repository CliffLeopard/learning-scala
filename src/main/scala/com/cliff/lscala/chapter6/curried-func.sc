/**
 * 偏作用函数
 * cat1具有两个参数列表
 * hello是cat1的偏作用函数，带参数s1的函数
 * man 是hello的偏作用函数，带参数s2
 * 注意man在定义时没有使用_
 */
def cat1(s1: String)(s2: String)(s3: String) = s1 + s2 + s3
val hello = cat1("Hello ") _
val man = hello("World ")

cat1("Hello ")("World ")("Man!")
hello("World ")("Man!")
man("Man!")


/**
 * 偏函数
 * 偏函数是单参数的函数，并没有对类型的所有值都有定义
 * 其字面量语法由包围在一个花括号中的多个case语句构成
 */
val inverse:PartialFunction[Double,Double] = {
  case d if d!=0.0 => 1.0/d
}

inverse(2.0)
inverse(0.0)  // 返回MatchError错误

/**
 * 偏作用函数和偏函数的区别
 * 偏作用函数是一个表达书，带部分而非全部的参数列表的函数，
 * 返回值是一个新函数，新函数负责携带剩下的参数列表.
 */