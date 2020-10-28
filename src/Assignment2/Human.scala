package Assignment2

object Human extends App {
  val john = new Human("John", "Doe", "Male")
  val monika = new Human("Monika", "Bing", "Female")
  val someone = new Human("Someone", "Guy")
  val noOne = new Human()

  greetPerson(john)
  greetPerson(monika)
  greetPerson(someone)
  greetPerson(noOne)

  def greetPerson(person: Human) : Unit = {
    person.gender match {
      case "Male" => println(s"Hello Mr. ${person.firstName} ${person.lastName}")
      case "Female" => println(s"Hello Ms. ${person.firstName} ${person.lastName}")
      case _ =>println(s"Hello dear ${person.firstName} ${person.lastName}")
    }
  }
}

class Human(val firstName: String, val lastName: String, val gender: String) {
  def this() {
    this("No First Name", "No Last Name", "No Gender")
  }

  def this(firstName: String, lastName: String) {
    this(firstName, lastName, "Not sure gender")
  }
}
