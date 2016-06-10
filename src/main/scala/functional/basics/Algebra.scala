package functional.basics

import scala.math._

/**
  * Created by leandrob13 on 6/9/16.
  */
object Algebra {

  /**
    * Pure function.
    */

  def square(n: Double): Double = pow(n, 2)

  def squareRoot(n: Double): Double = sqrt(n)

  def timesTwo(n: Double): Double = n * 2

  def sum(a: Double, b: Double): Double = a + b

  val substract: (Double, Double) => Double = (a: Double, b: Double) => a - b

  /**
    * Curried functions.
    */

  def sumCurried(a: Double)(b: Double): Double = a + b

  def sumCurried(a: Double): (Double) => Double = { b: Double =>
    a + b
  }

  /**
    * Higher order functions.
    */

  def binaryOp(a: Double, b: Double)(op: (Double, Double) => Double): Double = op(a, b)

  def binaryOp(a: Double)(b: Double)(op: Double => Double => Double): Double = op(a)(b)

  def numberToString(n: Long)(f: Long => String): String = f(n)

  /**
    * Composing functions.
    */

  def fourthPow(a: Double): Double = {
    val fourth: (Double) => Double = square _ andThen square _
    fourth(a)
  }

  def identity(a: Double): Double = {
    val id = square _ compose squareRoot
    id(a)
  }

  /**
    * Partial functions.
    */

  def partialSum: PartialFunction[(Long, Long), Long] = {
    case (a, b) => a + b
  }

  def one: PartialFunction[Double, Double] = {
    case 1 => timesTwo(1)
  }

  def two: PartialFunction[Double, Double] = {
    case 2 => square(2)
  }

  def three: PartialFunction[Double, Double] = {
    case 3 => substract(3, 1)
  }

  def four: PartialFunction[Double, Double] = {
    case 4 => squareRoot(4)
  }

  def any: PartialFunction[Double, Double] = {
    case x => squareRoot(x)
  }

  def partialStacking: PartialFunction[Double, Double] = one orElse two orElse three orElse four orElse any

  def partialCompose: PartialFunction[Double, Double] = one andThen two andThen three andThen four andThen any

  def partialExplicit: PartialFunction[Double, Double] = {
    case 1 => timesTwo(1)
    case 2 => square(2)
    case 3 => substract(3, 1)
    case x => squareRoot(x)
  }
}
