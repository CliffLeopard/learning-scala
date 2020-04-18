package com.cliff.lscala.chapter3

/**
 * Curry函数:又可以称为多参数列表函数
 */
object AboutFunction {
  def main(args: Array[String]): Unit = {
    println(
      inject(
        Array(1, 2, 3, 4),
        5,
        (x: Int, y: Int) => x + y
      )
    )

  }

  /**
   * 第三个参数为一个函数
   *
   * @param arr       迭代的数组
   * @param init      初始化值
   * @param operation 迭代函数
   * @return
   */
  def inject(arr: Array[Int], init: Int, operation: (Int, Int) => Int) = {
    /**
     * :+ 数组末尾添加一个元素，返回新的数组
     * +: 数组前面添加一个元素，返回新的数组
     */
    arr :+ init reduce operation
  }
}
