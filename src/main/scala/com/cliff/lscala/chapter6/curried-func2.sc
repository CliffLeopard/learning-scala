/**
 * 函数的Curry化,与UnCurried
 *
 * 如下可见cat3Curried是将cat3这样的单参数列表多参数的函数，
 * curry化为的多参数列表的的函数
 */

def cat3(s1: String, s2: String) = s1 + s2
cat3("Hello", "world")
val cat3Curried = (cat3 _).curried
cat3Curried("Hello")(" World")

def curriedHello = cat3Curried("Hello")
curriedHello(" World!")


val f1: String => String => String =
  (s1: String) => (s2: String) => s1 + s2

val f2: String => (String => String) =
  (s1: String) => (s2: String) => s1 + s2

f1("Hello ")("World!")
f2("Hello ")("World!")


/**
 * UnCurried化
 * 将多参数列表的函数转化为单参数列表多参数的函数
 */
val cat3UnCurried = Function.uncurried(cat3Curried)
cat3UnCurried("Hello", " World")
val ff1 = Function.uncurried(f1)
ff1("Hello", " World")
