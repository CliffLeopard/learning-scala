def positive(i: Int): Option[Int] =
  if (i > 0) Some(i) else None
val k1: Option[Int] = for {
  i1 <- positive(5)
  i2 <- positive(10 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(2 * i3)
} yield i1 + i2 + i3 + i4

val k2 = for {
  i1 <- positive(5)
  i2 <- positive(10 * i1)
  i3 <- positive(25 * i2)
  i4 <- positive(2 * i3)
  i5 = i1 + i2 + i3 + i4
}yield i5

val k3: Option[Int] = for {
  i1 <- positive(5)
  i2 <- positive(-1 * i1) //-- 这里一旦是None类型，程序将在此终止。
  i3 <- positive(25 * i2)
  i4 <- positive(-2 * i3)
} yield i1 + i2 + i3 + i4

val k3: Option[Int] = for {
  i1 <- positive(5)
  i2 <- positive(-1 * i1) //-- 这里一旦是None类型，程序将在此终止。
  i3 <- positive(25 * i2)
  i4 <- positive(-2 * i3)
  i5 = i1 + i2 + i3 + i4
} yield i5

// 这里变量z表示了元组(1,2),变量x,y分别表示元组中的元素1，2
val z@(x, y) = (1 -> 2)

val m@(x, y) = (1, 2)

