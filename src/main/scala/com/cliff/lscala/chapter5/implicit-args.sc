def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

object SimpleStateSalesTax {
  implicit val rate: Float = 0.05F
}

case class ComplicatedSalesTaxData(
                                    baseRate: Float,
                                    isTaxHoliday: Boolean,
                                    storeId: Int)

object ComplicatedSalesTax {
  private def extraTaxRateForStore(id: Int): Float = {
    0.0F
  }

  implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float =
    if (cstd.isTaxHoliday) 0.0F
    else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
}

{
  import SimpleStateSalesTax.rate
  val amount = 100F
  val tax = calcTax(amount)
  println(tax == 5.0)
}

{
  import ComplicatedSalesTax.rate
  implicit val myStore = ComplicatedSalesTaxData(0.06F, false, 1010)
  val amount = 100F
  val tax = calcTax(amount)
  println(tax == 6.0)
}

case class MyList[A](list: List[A]) {
  def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] =
    list.sortBy(f)(ord)

  def sortBy2[B: Ordering](f: A => B): List[A] =
    list.sortBy(f)(implicitly[Ordering[B]])
}

val list = MyList(List(1, 4, 6, 8, 9, 2, 3))
list sortBy1 (i => i)
list sortBy1 (i => i.toString)
list sortBy1 (i => (-i).toString)
list sortBy2 (i => -i)

val orList = List(1, 2, 3, 4, 5)
orList.sortBy(i => i)