package Assignment2

object BankAccount extends App {

  val myAccount = new BankAccount
  myAccount.deposit(100)
  myAccount.withdraw(150)
  myAccount.withdraw(80)

}

class BankAccount(currentBalance: Float) {
  private var _currentBalance: Float = currentBalance

  def this() {
    this(0)
  }

  def deposit(amount: Float): Option[Boolean] = {
    try {
      this._currentBalance += amount
      println(s"Deposit accepted for $amount")
      Some(true)
    } catch {
      case e: Exception =>
        println(s"Cannot deposit $amount, please try later")
        None
    }
  }

  def withdraw(amount: Float): Float = {
    if (this._currentBalance >= amount) {
      this._currentBalance -= amount
      println(s"Withdrawn $amount")
    }
    else {
      println("You do not have sufficient amount.")
    }
    this._currentBalance
  }

}
