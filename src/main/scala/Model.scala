package de.retikulo

import java.time.LocalDate

case class Account(id: Long, name: String)
case class DbError(response: String)
case class Entry(id: Long, name: String, datum: LocalDate, wert: BigDecimal)
