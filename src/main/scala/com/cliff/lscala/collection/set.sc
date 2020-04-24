val states = Set("A", "B", "C", "D", "E")
states // 非定序

val lowerStates = states map (_.toLowerCase())

states+"F"

states + ("K","G","M")