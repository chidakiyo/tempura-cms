import play.api._
import com.typesafe.scalalogging._
import play.api.mvc.RequestHeader
import play.api.mvc.Handler
import play.api.Configuration
import com.typesafe.config.ConfigFactory
import org.apache.velocity.app.Velocity
import util.Database

object Global extends GlobalSettings with LazyLogging {

  override def onStart(app: Application) {
    logger.debug("## onStart")

    // sclike-jdbc
    Database.init()

    // Velocity
    Velocity.init()
  }

  override def beforeStart(app: Application) {
    logger.debug("## beforeStart")
    super.beforeStart(app)
  }

  override def onStop(app: Application) {
    logger.debug("## onStop")
    super.onStop(app)
  }

  override def onRequestReceived(request: RequestHeader): (RequestHeader, Handler) = {
    logger.debug("## onRequestReceived")
    super.onRequestReceived(request)
  }

}