def positive(i: Int): Either[String, Int] =
  if (i > 0) Right(i) else Left(s"nonPositive number $i")
for {
  i1 <- positive(5).right
  i2 <- positive(10 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(2 * i3).right
} yield (i1 + i2 + i3 + i4)

for {
  i1 <- positive(5).right
  i2 <- positive(-1 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(-2 * i3).right
} yield (i1 + i2 + i3 + i4)

val l: Either[String, Int] = Left("boo")
val r: Either[String, Int] = Right(12)
// 另外一种定义方式：中缀表示法表示类型说明
val l1: String Either Int = Left("boo")

type Or[A, B] = Either[A, B]
val l3: String Or Int = Left("boo")

val l4 = Left("boo")
l4.left
l4.right

l4.left map (_.size)
r.left.map(_.size)
r.right.map(_*10)