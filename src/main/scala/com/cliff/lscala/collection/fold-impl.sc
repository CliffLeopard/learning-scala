
// 自己实现foldLeft
def reduceLeft[A, B](s: Seq[A])(f: A => B): Seq[B] = {
  @annotation.tailrec
  def rl(accum: Seq[B], s2: Seq[A]): Seq[B] = s2 match {
    case head +: tail => rl(f(head) +: accum, tail)
    case _ => accum
  }

  rl(Seq.empty[B], s)
}

// 自己实现foldRight
def reduceRight[A, B](s: Seq[A])(f: A => B): Seq[B] = s match {
  case head +: tail => f(head) +: reduceRight(tail)(f)
  case _ => Seq.empty[B]
}

val list = List(1, 2, 3, 4, 5, 6)
reduceLeft(list)(2 * _)
reduceRight(list)(2 * _)

val list2 = list.fold(List.empty) {
  (a, b) => {
    (a, b) match {
      case (a1: List[Int], b1: Int) =>
        //      a1 :+ 2*b1
        2 * b1 :: a1
      case _ => Nil
    }
  }
}
