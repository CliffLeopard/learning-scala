package com.cliff.lscala.chapter8

object Database {

  case class ResultSet()

  case class Connection()

  case class DatabaseException(message: String, cause: Throwable) extends RuntimeException(message, cause)

  sealed trait Status

  case object Disconnected extends Status

  case class Connected(connection: Connection) extends Status

  case class QuerySucceed(results: ResultSet) extends Status

  case class QueryFiled(e: DatabaseException) extends Status

}

class Database {

  import Database._

  def connect(server: String): Status = ???

  def disconnect(): Status = ???

  def query(): Status = ???

}
