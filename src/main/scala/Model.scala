package de.retikulo

import java.time.LocalDate

case class Account(name: String, entries: List[Entry])
case class DbError(response: String)
case class Entry(name: String, datum: LocalDate, wert: BigDecimal)
case class Transaction(from: Account, to: Account, date: LocalDate)
