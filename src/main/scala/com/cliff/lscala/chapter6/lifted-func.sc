/**
 * 偏函数与Option之间的相互转化　
 */
val finicky: PartialFunction[String, String] = {
  case "finicky" => "FINICKY"
}
finicky("finicky")
//finicky("FUCK")  scala.MatchError

//偏函数转化为Option
val finickyOption = finicky.lift
finickyOption("finicky")
finickyOption("Other")

//Option 转化为偏函数
val finicky2 = Function.unlift(finickyOption)
finicky2("finicky")
//finicky2("Other") scala.MatchError