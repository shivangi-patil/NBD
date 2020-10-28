package Assignment2

import scala.annotation.tailrec

object ParameterFunction extends App {
  def incrementFunc(number: Int): Int = {
    number + 1
  }

  def increaseByThree(number: Int, func: Int => Int): Int = {
    @tailrec
    def helper(counter : Int, result: Int): Int = {
      if (counter == 0) result
      else helper(counter-1, func(result))
    }
    helper(3, number)
  }

  println(increaseByThree(5, incrementFunc))
}
