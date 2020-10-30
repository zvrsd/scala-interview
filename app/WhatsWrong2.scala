package com.particeep.test

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

case class CEO(id: String, first_name: String, last_name: String)
case class Enterprise(id: String, name: String, ceo_id: String)

object CEODao {
  val ceos = List(
    CEO("1", "Mark", "Zuckerberg"),
    CEO("2", "Sundar", "Pichai")
  )

  def byId(id: String): Future[Option[CEO]] = Future { ceos.find(_.id == id) }
}

object EnterpriseDao {
  val enterprises = List(
    Enterprise("1", "Google", "1"),
    Enterprise("2", "Facebook", "2")
  )

  def byId(id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.id == id) }
  def byCEOId(ceo_id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.ceo_id == ceo_id) }
}

object WhatsWrong2 {

  //Review this code. What could be done better ? How would you do it ?
  /*
   * Afaik Mark Zuckerberg is not the CEO of Google but im pretty sure that's not the point
   *
   * I'm not really sure on what could be done better, understanding this code was a bit tricky at first and im not
   * comfortable enough with those Future Objects
   * Maybe, since this seem to be an async task, we could include a callback method as a parameter,
   * so all we will have to do is to provide the ceo_id and callback, and once the data has been
   * obtained from the DAO, the callback function runs automatically
   *
   * In short, instead of returning this Future object, we add a callback method as a parameter
   *
   */
  def getCEOAndEnterprise(ceo_id: Option[String]): Future[(Option[CEO], Option[Enterprise])] = {
    for {
      ceo <- CEODao.byId(ceo_id.get)
      enterprise <- EnterpriseDao.byCEOId(ceo_id.get)
    } yield {
      (ceo, enterprise)
    }
  }
}
