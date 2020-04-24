val vect1 = Vector("A", "B")
val vect2 = "A" :+ "B" :+ "C"
val vect3 = "A" +: "B" +: "C"
val vect4 = "C" :+ vect1
val vect5 = "C" +: vect1
val vect6 = vect1 +: "C"
val vect7 = vect1 :+ "C"