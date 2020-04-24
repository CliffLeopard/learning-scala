/**
 * 显然Curry化与偏应用函数是可以互换的两个概念
 */
def multiplier(i: Int)(factor: Int) = i * factor
val byFive = multiplier(5) _
val byTen = multiplier(10) _
byFive(2)
byTen(2)

/**
 * tupled的作用是将是三个参数函数，转化为参数为3元素元组的函数
 */

def mut(d1: Double, d2: Double, d3: Double) = d1 * d2 * d3
def mut2(d1: Double)(d2: Double)(d3: Double) = d1 * d2 * d3
val d3 = (2.1, 3.1, 4.2)
mut(d3._1, d3._2, d3._3)

val mutTupled = Function.tupled(mut _)
mutTupled(d3)

val mutUntupled = Function.untupled(mutTupled)
mutUntupled(d3._1, d3._2, d3._3)





