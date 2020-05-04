val map = Map("one" -> 1, "two" -> 2)
/**
 * for推到式在scala中的转化过程，
 * list1在scala内部实际上是转化为list2的执行过程进行执行的
 */
val list1 = for {
  (_, value) <- map
  i10 = value + 10
} yield (i10)


val list2 = for {
  (_, i10) <- for {
    x1@(_, value) <- map
  } yield {
    val x2 = value + 10
    println((x1, x2))
    (x1, x2)
  }
} yield i10

