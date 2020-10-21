package Assignment1

import scala.annotation.tailrec

object DaysOfTheWeek extends App {

  val daysList : List[String]=  List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

  def returnAStringUsingFor : String = {
    var i = 1
    var days = daysList(0)

    for (i <- 1 to daysList.length-1) {
      days = days + "," + daysList(i)
    }
    days
  }
  println("Output for 1-a : " + returnAStringUsingFor)

  def returnAStringUsingForWithConstraint : String = {
    var i = 0
    var days = ""

    for (i <- daysList.indices) {
      if (daysList(i).charAt(0) == 'S') {
        days = days + "," + daysList(i)
      }
    }
    days.substring(1)
  }
  println("Output for 1-b : " + returnAStringUsingForWithConstraint)

  def returnAStringUsingWhile : String = {
    var i = 1
    var days = daysList(0)

    while (i < daysList.length) {
       days = days + "," + daysList(i)
       i += 1
    }
    days
  }
  println("Output for 1-c : " + returnAStringUsingWhile)

  def returnAStringUsingRecursion (i : Int = 0) : String = {
    if (i == daysList.length-1) daysList(i)
    else {
      var days: String = daysList(i) + "," + returnAStringUsingRecursion(i+1)
      days
    }
  }
  println("Output for 2-a : " + returnAStringUsingRecursion())

  def returnAStringLastToFirstUsingRecursion (i : Int = 0) : String = {
    if (i == daysList.length-1) daysList(i)
    else {
      var days: String = returnAStringLastToFirstUsingRecursion(i+1) + "," +  daysList(i)
      days
    }
  }
  println("Output for 2-b : " + returnAStringLastToFirstUsingRecursion())


  def returnAStringUsingTailRecursion(): String = {
    @tailrec
    def helper (i : Int = 0, days: String = ""): String =
      if (i == daysList.length) days.substring(1)
      else helper(i+1, days + "," + daysList(i))

    helper()
  }
  println("Output for 3 : " + returnAStringUsingTailRecursion())

  println("Output for 4-a : " + daysList.foldLeft("")((days, currentDay) => days + "," + currentDay).substring(1))
  println("Output for 4-b : " + daysList.foldRight("")((days, currentDay) => days + "," + currentDay).dropRight(1))
  println("Output for 4-c : " + daysList.foldLeft("")((days, currentDay) => {
    if (currentDay.charAt(0) == 'S') days + "," + currentDay
    else ""
  }).substring(1))

}
