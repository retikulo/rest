package de.retikulo

import java.time.LocalDate
import scala.collection.convert.ImplicitConversions.`collection asJava`

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, world")
    val account = Account("name", List(Entry("1", LocalDate.now(), BigDecimal(5))))
    account.entries.add(Entry("4", LocalDate.now(), BigDecimal(69)))

    println(account)
  }
}
