package com.cliff.lscala.chapter5

/**
 * 当前函数的返回值作为参数传递到下一个函数
 */
object Pipeline {

  implicit class toPiped[V](value: V) {
    def |>[R](f: V => R) = f(value)
  }

}


object CalculatePayroll2 {
  def main(args: Array[String]): Unit = {
    import Pipeline._
    import Payroll._

    val e = Employee("Buck Trends", 100000.0F, 0.25F, 200F, 0.10F, 0.05F)
    val pay = start(e) |>
      minus401k |>
      minusInsurance |>
      minusTax |>
      minusFinalDeductions

    /**
     * 这里进行一下说明：
     * 当调用start(e)，返回 pay:Pay[PreTaxDeductions]
     * pay:Pay[PreTaxDeductions]遇到 |>函数，隐式类型转化为toPiped类的实例，toPip:toPiped[PreTaxDeductions](pay)
     * toPip调用 |> 函数，参数为minus401K函数，则执行了minus401k(pay)的操作
     * 从而完成了将当前函数的结果作为参数传递给下一个函数的操作。
     */
    val twoWeekGross = e.annualSalary / 26.0F
    val twoWeekNet = pay.netPay
    val percent = (twoWeekNet / twoWeekGross) * 100
    println(s"For ${e.name}, the gross vs. net pay every 2 weeks is:")
    println(
      f"  $$${twoWeekGross}%.2f vs. $$${twoWeekNet}%.2f or ${percent}%.1f%%")
  }
}