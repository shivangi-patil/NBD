package Assignment1

import scala.annotation.tailrec


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


  def printTupple(tuple: (Int, String, Boolean)): Unit = {
    println(tuple._1, tuple._2, tuple._3)
  }
  val myTuple = (1, "Shivangi", true)
  print("Output for 8: ")
  printTupple(myTuple)

  def removeZeros(arr: List[Int]): List[Int] = {
    @tailrec
    def helper(arr: List[Int], acc: List[Int]): List[Int] = {
      if (arr.isEmpty) acc
      else helper(arr.tail, if(arr.head == 0) acc else acc :+ arr.head)
    }

    helper(arr, List[Int]())
  }
  println("Output for 9: " + removeZeros(List(4, 0, 2, 0, 0, 10, 7)) )

  def OptionExample(): Unit = {
    val a: Option[Int] = Some(10)
    val b: Option[String] = Some("Assignment")
    val c: Option[Int] = None

    println(s"Output for 10, Example 1 : ${a.isEmpty} ${b.isEmpty} ${c.isEmpty}")
  }
  println(OptionExample())

  def toInteger(num: String): Option[Int] = {
    try {
      Some(Integer.parseInt(num.trim))
    } catch {
      case e: Exception => None
    }
  }
  print("Output for 10, Example 2 : ")
  //here if you change the value of num to eg. 34554, it will go to try block and convert the string to integer
  toInteger("abc1234") match  {
    case Some(number) => println(number)
    case None => println("Cannot convert to integer.")
  }

}
