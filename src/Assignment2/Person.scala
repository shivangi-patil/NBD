package Assignment2

object Person extends App {
  val student = new Person("John", "Doe") with Student
  println(s"Just a Student pays: ${student.taxToPay} taxes")

  val workingStudent = new Person("Monika", "Bing") with Employee with Student
  workingStudent.salary = 2000
  println(s"Employee Student pays: ${workingStudent.taxToPay} taxes")

  val studentWorking = new Person("Chandler", "Bing") with Student with Employee
  studentWorking.salary = 3000
  println(s"Student Employee pays: ${studentWorking.taxToPay} taxes")

  val teacher = new Person("Ross", "Geller") with Teacher
  teacher.salary = 4000
  println(s"Teacher pays: ${teacher.taxToPay} taxes")

}

class Person(val firstName: String, val lastName: String) {
  private val _taxToPay: Float = 0

  def this() {
    this("NO_FIRST_NAME", "NO_LAST_NAME")
  }

  def taxToPay: Float = _taxToPay
}

trait Student extends Person {
  override def taxToPay: Float = 0
}

trait Employee extends Person {
  private var _salary: Float = 0

  val _taxToPay: Float = 20

  def salary: Float = _salary
  def salary_= (value: Float): Unit = {
    _salary = value
  }

  override def taxToPay: Float = _taxToPay/100 * _salary
}

trait Teacher extends Employee {
  override val _taxToPay: Float = 10
}
