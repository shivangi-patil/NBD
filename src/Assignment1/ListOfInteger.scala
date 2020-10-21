package Assignment1

import scala.annotation.tailrec
import scala.math._


object ListOfInteger extends App{

  def listFunction: List[Int] = {
    print("enter the number of elements you want in the list: ")
    val n :Int = scala.io.StdIn.readInt()
    print("Enter elements in list:")
    val integerList = List.fill(n) {
      scala.io.StdIn.readInt()
    }

    integerList.map(_ + 1)
  }
//  print("Output for 6: " + listFunction)

  def listRealNumbersFunction(nums: List[Int]): List[Int] = {
    nums.map(num => {
      if (num < -5 || num > 12) num
      else math.abs(num)
    })
  }
  val realNumbers = List(-7, 4, -3, -4, 0, -5, -8, 13)
  println("Output for 7: " + listRealNumbersFunction(realNumbers))


  def printTupple(tuple: (Int, String, Boolean)) = {
    println(tuple._1, tuple._2, tuple._3)
  }
  val myTuple = (1, "Shivangi", true)
  print("Output for 8: ")
  printTupple(myTuple)

  def removeZeros(arr: List[Int]): List[Int] = {
    @tailrec
    def helper(index: Int = 0, acc: List[Int]): List[Int] = {
      if (index == arr.length) acc
      else helper(index+1, if(arr(index) == 0) acc else acc :+ arr(index))
    }

    helper(0, List[Int]())
  }
  println("Output for 9: " + removeZeros(List(4, 0, 2, 0, 0, 10, 7)) )

  def toInteger(num: String): Option[Int] = {
    try {
      Some(Integer.parseInt(num.trim))
    } catch {
      case e: Exception => None
    }
  }
  print("Output for 10: ")
  //here if you change the value of num to eg. 34554, it will go to try block and convert the string to integer
  toInteger("abc1234") match  {
    case Some(number) => println(number)
    case None => println("Cannot convert to integer.")
  }


}
