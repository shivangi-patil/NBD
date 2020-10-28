package Assignment2

object patternMatching extends App {

  def getDayType(str: String): String = {
    val lowerStr = str.toLowerCase
    val weekDays = List("monday", "tuesday", "wednesday", "thursday", "friday")
    val weekendDays = List("saturday", "sunday")

    lowerStr match {
      case lowerStr: String if weekDays.exists(lowerStr.contains(_)) => "work"
      case lowerStr: String if weekendDays.exists(lowerStr.contains(_)) => "weekend"
      case _ => "no such day"
    }
  }
  println("Output for 1: " + getDayType("Today is monday"))

}
