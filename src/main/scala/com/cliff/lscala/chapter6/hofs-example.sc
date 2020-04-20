1 to 10 filter(_%2 == 0) map(_*2) reduce(_*_)


/**
 * 下面的函数 创建了一个闭包：
 * factor不是一个参数而是自由变量，是当前作用域中某个值的引用
 */

var factor = 2
val multiplier = (i:Int) =>i * factor
1 to 10 filter(_%2 == 0) map multiplier reduce(_*_)

factor = 3
1 to 10 filter(_%2 == 0) map multiplier reduce(_*_)

/**
 * 几个概念:
 * 1. 函数:一种具名或匿名的操作，其代码知道被调用是才执行，在函数的定义中，
 * 可能有也可能没有引用外部的未绑定变量
 * 2. Lambda: 一种匿名函数，可能有也可能没有引用外部的未绑定变量。在Scala中
 * 也称为函数字面量
 * 3. 闭包: 是一个函数，可能匿名也可能具名，在定义中包含了自由变量，函数中
 * 包含了环境信息，以绑定其引用的自由变量。
 */
