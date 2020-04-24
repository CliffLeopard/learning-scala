import com.cliff.lscala.chapter5.CPipLine.Piped

List(1, 2, 3, 4, 5) foreach (_ |> println)

val list = List("now", "is", "", "the", "time")
list foreach (x => println(x))
val list2 = list map (_.toList)
val list3 = list flatMap (_.toList)


list2.flatten
list2.flatten == list3

list.drop(1)
list.dropWhile(str => str.length == 0)
list.filter(str => str.length > 1)
list.filterNot(str => str.length > 1)
list.find(str => str.length == 3).get
list.forall(str => str.length >= 0)
list.partition(str => str.length > 2)
list.take(3)
list.takeRight(2)
list.takeWhile(str => str.length > 0)


/**
 * fold = foldLeft
 * foldLeft vs foldRight
 * foldLeft可以进行尾递归优化
 * foldRight可以保持原有序列，对于无限数据流可以随意截断，
 * 但是在 trait LinearSeqOptimized中foldRight是使用递归的方式实现的，而别不是尾递归，
 * 所以当递归层次太多时容易OOM
 * 但是在List中foldRight的实现方式是不同的，他通过reverse之后使用foldLeft
 * 实现，所以效率会低下(循环两遍),但是不用考虑递归层级太多的问题
 */
val listNumber = List(1, 3, 5, 7, 9, 11, 30)
listNumber reduce (_ + _)
listNumber.fold(100)(_ + _)
listNumber.fold(100)(_ + _)
listNumber.foldRight(100)(_ + _)
listNumber.fold("100")(_.toString + _)
listNumber.foldLeft("100")(_ + _.toString)
listNumber.foldRight("100")(_.toString + _)



val listFold = listNumber.fold(100) _
listFold(_ + _)

listNumber.sum
listNumber.slice(2, 5)

