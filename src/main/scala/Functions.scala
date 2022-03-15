package de.retikulo

object Functions {
  def createAccount(account: Account, username: String): Boolean = {
    createAccountInDatabase(account, username, null) match {
      case Right(_) => true
      case Left(_) => false
    }
  }

  def createAccountInDatabase(account: Account, username: String, connection: Object): Either[DbError, Account] = {
    // create db entry
    Right(Account("hello", List.empty))
  }
}
