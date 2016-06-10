package functional.basics

/**
  * Created by leandrob13 on 6/9/16.
  */
object OtherScope {

  class Foo {

    // a method that takes a function and a string, and passes the string into

    // the function, and then executes the function

    def exec(f:(Int) => Int, value: Int): Int = {

      f(value)

    }

  }

}

object ClosureExample {

  var number = 1

  def inc(a: Int) = a + number

  // execute sayHello from the exec method foo

  def run: Unit = {
    val foo = new OtherScope.Foo

    println(s"RESULT ${foo.exec(inc, 1)}")
    println(s"RESULT ${foo.exec(inc, 1)}")
    //foo.exec(inc, 1)

    // change the local variable 'hello', then execute sayHello from

    // the exec method of foo, and see what happens

    number = 100

    println(s"RESULT ${foo.exec(inc, 5)}")
    println(s"RESULT ${foo.exec(inc, 6)}")
  }

}
