import play.api._
import com.typesafe.scalalogging._
import play.api.mvc.RequestHeader
import play.api.mvc.Handler
import play.api.Configuration
import com.typesafe.config.ConfigFactory
import scalikejdbc._
import org.apache.velocity.app.Velocity

object Global extends GlobalSettings with LazyLogging {

  override def onStart(app: Application) {
    logger.debug("## onStart")

    val config = Configuration(ConfigFactory.load())
    val driver = config.getString("db.default.driver").getOrElse(null)
    val url = config.getString("db.default.url").getOrElse(null)
    val user = config.getString("db.default.user").getOrElse(null)
    val pass = config.getString("db.default.password").getOrElse(null)
    logger.debug("[ CONFIG ] " + driver)
    logger.debug("[ CONFIG ] " + url)
    logger.debug("[ CONFIG ] " + user)
    logger.debug("[ CONFIG ] " + pass)

    Class.forName(driver)
    (user, pass) match {
      case user == null && pass == null => ConnectionPool.singleton(url)
      case _ => ConnectionPool.singleton(url, user, pass)
    }

    // Velocity
    Velocity.init()
  }

  override def beforeStart(app: Application) {

    val config = Configuration(ConfigFactory.load())
    val driver = config.getString("db.default.driver").getOrElse("")
    val url = config.getString("db.default.url").getOrElse("")
    val user = config.getString("db.default.user").getOrElse("")
    val pass = config.getString("db.default.password").getOrElse("")
    logger.debug("[ CONFIG ] " + driver)
    logger.debug("[ CONFIG ] " + url)
    logger.debug("[ CONFIG ] " + user)
    logger.debug("[ CONFIG ] " + pass)

    logger.debug("## beforeStart")
  }

  override def onStop(app: Application) {
    logger.debug("## onStop")
  }

  override def onRequestReceived(request: RequestHeader): (RequestHeader, Handler) = {
    logger.debug("## onRequestReceived")
    super.onRequestReceived(request)
  }

}