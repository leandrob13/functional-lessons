import functional.basics.Algebra._
import functional.basics.ClosureExample._
import scala.util.Random

//Funciones puras e impuras
var z = 1
def alt(a: Int) = z + a
alt(1)
alt(1)
alt(1)
def inc(a: Int) = {
  z = z + 1
  z
}
inc(1)
inc(1)
inc(1)

//Transparencia Referencial
val res = sum(1, 1)
sum(1, 1) + sum(1, 1) == res + res
sum(1, 1) + sum(1, 1) == 2 * sum(1, 1)
2 + sum(1, 1) == 2 * sum(1, 1)
sum(1, 1)
sum(1, 1)

//Funcion parcialmente aplicada
val partialSum: (Double) => Double = sum(1, _)
partialSum(2)
//composicion
val operation: (Double, Double) => Double = sum
val x: ((Double, Double)) => Double = operation.tupled andThen square
x(1, 2)
//funciones anonimas y parciales
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
//currying y funciones parcialmente aplicadas
val op1: (Double) => ((Double) => (Double) => Double) => Double = binaryOp(1)
val op2 = op1(2)
val op3: Double = op2(x => y => x + y)
op3 == binaryOp(1)(2)(sumCurried)
op3 == binaryOp(1)(2)(sumCurriedHigherOrder)
numberToString(2)(_.toString)
numberToString(2)(n => s"The number is $n")
numberToString(Random.nextInt(5).toLong){
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "wtf"
}


//closures
run
run
run