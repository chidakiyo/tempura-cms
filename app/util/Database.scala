package util

import com.typesafe.scalalogging.LazyLogging
import play.api.Configuration
import com.typesafe.config.ConfigFactory
import scalikejdbc._

object Database extends LazyLogging {

  def init() = {
    logger.debug("INIT DATABASE")
    val (driver, url, user, pass) = loadConfig()

    logger.debug("[ CONFIG ] " + driver)
    logger.debug("[ CONFIG ] " + url)
    logger.debug("[ CONFIG ] " + user)
    logger.debug("[ CONFIG ] " + pass)

    Class.forName(driver)
    ConnectionPool.singleton(url, user, pass)
  }

  def loadConfig(): (String, String, String, String) = {
    implicit val conf = Configuration(ConfigFactory.load())
    (x("db.default.driver"), x("db.default.url"), x("db.default.user"), x("db.default.password"))
  }

  private def x(key: String)(implicit conf: Configuration): String = {
    conf.getString(key).getOrElse(null)
  }

}