import functional.basics.Algebra._
import scala.util.Random
val partialSum: (Double) => Double = sum(1, _)
partialSum(2)
val op: (Double, Double) => Double = sum
val x: ((Double, Double)) => Double = op.tupled andThen square
x(1, 2)
binaryOp(16, 8) {
  case (a, b) => squareRoot(a) + timesTwo(b)
}
binaryOp(4, 2)(_ + _)
binaryOp(4, 2)( (a, b) => a + b )
binaryOp(4, 2)(sum)
binaryOp(4, 2)((a, b) => sum(a, b))
binaryOp(4, 2) {
  case (a, b) => sum(a, b)
}
val op2: (Double) => ((Double) => (Double) => Double) => Double = binaryOp(1)
val op3: ((Double) => (Double) => Double) => Double = op2(2)
val op4 = op3(x => y => x + y)


numberToString(2)(_.toString)
numberToString(2)(n => s"The number is $n")
numberToString(Random.nextInt(5).toLong){
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "wtf"
}