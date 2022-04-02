package de.retikulo

object Main {
  def main(args: Array[String]): Unit = {
    println(Functions.createAccountInDatabase(Account(52, "Greg"), "abc", "abc"))
  }
}
