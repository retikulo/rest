package de.retikulo

import slick.jdbc.H2Profile.api._

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object Functions {
  def createAccount(account: Account, username: String): Boolean = {
    createAccountInDatabase(account, username, null) match {
      case Right(_) => true
      case Left(_) => false
    }
  }

  def createAccountInDatabase(account: Account, username: String, connection: Object): Either[DbError, Account] = {

    class AccountTable(tag: Tag) extends Table[Account](tag, None, "Account") {
      override def * = (id, name) <> (Account.tupled, Account.unapply)

      val id: Rep[Long] = column[Long]("AccountId", O.AutoInc, O.PrimaryKey)
      val name: Rep[String] = column[String]("Name")
    }

    val db = Database.forConfig("h2mem")

    val accountTable = TableQuery[AccountTable]

    val setup = DBIO.seq(
      accountTable.schema.create,
      accountTable += account
    )
    val setupFuture = db.run(setup)
    Await.result(setupFuture, 5 seconds)

    Await.ready(db.run(accountTable += Account(99, "Greg")), 5 seconds)

    val gregQuery = accountTable.filter(_.name === "Greg")
    val gregFuture: Future[Seq[Account]] = db.run[Seq[Account]](gregQuery.result)
    Await.result(gregFuture, 5 seconds)
    val result = Await.result(gregFuture, 5 seconds)
    if (result.nonEmpty) Right(result.head) else Left(DbError("error"))
  }
}
