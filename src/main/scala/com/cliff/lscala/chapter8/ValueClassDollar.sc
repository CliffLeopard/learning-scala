
/**
 * 怎样扩展值类型的功能呢？
 * 方法 1:
 * 扩展方法:引入包装类型来实现新类型
 * 缺点：当包装值类型时会变为引用类型，失去了值类型的高效性。
 * 可见 [[com.cliff.lscala.chapter5.ToJsonTypeClass]]
 */



/**
 * 方法2:
 * 价值类
 * 扩展方法：使用包装类型来实现新的类型。 这样值类型就变为了引用类型
 * @param value
 */
class ValueClassDollar(val value: Float) extends AnyVal {
  override def toString: String = "$%.2f".format(value)
}

val benjamin = new ValueClassDollar(100)


