val boolSeq = Seq(false, true)
for (bool <- boolSeq) {
  bool match {
    case true => println("Got Tail")
    case false => println("Got Head")
  }
}