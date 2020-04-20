/**
 * 此文件来讲述Scala函数式编程中的递归
 * 用递归来实现斐波那契数列
 * import是引入尾递归检测
 */

import scala.annotation.tailrec

//@tailrec  这里不能添加尾递归检测，因为此时不是尾递归
def factorial(i: BigInt): BigInt = {
  if (i == 1) i
  else i * factorial(i - 1)
}
for (i <- 1 to 10)
  println(s"$i : ${factorial(i)}")


/**
 * 进行尾递归改造
 *
 * @param i
 * @return
 */
def factorial2(i: BigInt): BigInt = {
  @tailrec
  def fact(i: BigInt, now: BigInt): BigInt = {
    if (i == 1) now
    else fact(i - 1, i * now)
  }

  fact(i, 1)
}

for (i <- 1 to 10)
  println(s"$i : ${factorial2(i)}")



