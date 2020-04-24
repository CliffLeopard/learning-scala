val info = Map(
  "name" -> "Cliff",
  "age" -> 20,
  "height" -> 200
)

/**
 * COption中可知
 * Map中存储的是一个个Tuple2
 * Tuple2又可称为Pair, 两种表示方式 A->B, (A,B)
 */
val detail = info + ("look" -> "handsome")
val detail2 = info + Tuple2("look", "ugly")
val detail3 = info + (("look", "ugly"))
//val detail4 = info + ("look", "ugly") 少一个括号是不可以的

