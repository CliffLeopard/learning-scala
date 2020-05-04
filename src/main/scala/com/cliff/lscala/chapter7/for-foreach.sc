val status = List("A", "bC", "DeF", "JhiG")

for {
  s <- status
} println(s)

for {
  s <- status
} yield s.toUpperCase

for {
  s <- status
  c <- s
} yield s"$c-${c.toUpper}"

for {
  s <- status
  c <- s
  if c.isLower
} yield s"$c-${c.toUpper}"

/**
 * withFilter和Filter的区别，
 * withFilter可以减少中间数据的产生，特别适用于链式调用中在中间环节进行过滤。
 * filter则会将原有原有集合转化为过滤后的新的集合。
 */
status flatMap (_ withFilter (_.isLower) map (c => s"$c-${c.toUpper}"))