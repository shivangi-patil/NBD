package Assignment9

object lab9 extends App {
  println("Task1")
  val initialValue: String = "Batman"
  println(s"Initial value: ${initialValue}")
  val task1: Task1[String] = new Task1(initialValue)
  task1.applyFunction(a => a + a)
  println(s"Value after applying the function: ${task1.getContent}")
  println()


  println("Task2")
  val no: No = new No()
  println(s"No is subtype of Maybe: ${no.isInstanceOf[Maybe[_]]}")
  val yes: Yes[String] = new Yes("a")
  println(s"Yes is subtype of Maybe: ${yes.isInstanceOf[Maybe[_]]}")
  println()


  println("Task3")
  val task3no: Task3[No] = new Task3[No](new No())
  task3no.applyFunction(a => a)
  println(task3no.getContent)
  val task3yes: Task3[Yes[String]] = new Task3[Yes[String]](new Yes(initialValue))
  task3yes.applyFunction(a => new Yes(a.getContent + a.getContent))
  println(task3yes.getContent.getContent)
  println()


  println("Task4")
  val task4no: Task4[No] = new Task4[No](new No())
  println(task4no.getOrElse)
  val task4yes: Task4[Yes[String]] = new Task4[Yes[String]](new Yes(initialValue))
  println(task4yes.getOrElse)
}

// Task 1
class Task1[A](value: A) {
  private var _value: A = value

  def getContent: A = _value
  def applyFunction(f: A => A): A = {
    _value = f(_value)
    _value
  }
}


// Task 2
trait Maybe[A]

class No extends Maybe[Nothing]

class Yes[A](value: A) extends Maybe[A] {
  private val v: A = value

  def getContent: A = v
}


// Task 3
class Task3[A](value: A) {
  private var _value: A = value

  def getContent: A = _value
  def applyFunction(func: A => A): A = {
    if (func(_value).isInstanceOf[No]) {
      _value
    } else if (func(_value).isInstanceOf[Yes[_]]) {
      _value = func(_value).asInstanceOf[A]
      _value
    } else
      null.asInstanceOf[A]
  }
}


// Task 4
class Task4[A](value: A) {
  private val _value: A = value

  def getContent: A = _value
  def getOrElse[B]: B = {
    if (_value.isInstanceOf[No])
      "This is class NO with no content".asInstanceOf[B]
    else if (_value.isInstanceOf[Yes[_]])
      _value.asInstanceOf[Yes[A]].getContent.asInstanceOf[B]
    else
      null.asInstanceOf[B]
  }
}