package functional.basics

/**
  * Created by leandrob13 on 6/9/16.
  */
object Recursion {

  def factorial(i: Int): Int = i match {

    case 1 => i

    case _ => i * factorial(i - 1)

  }

  def tailFactorial(i: Int): Int = {

    def fact(i: Int, accumulator: Int): Int = i match {

      case 1 => accumulator

      case _ => fact(i - 1, i * accumulator)

    }

    fact(i, 1)

  }
}
