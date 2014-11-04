import play.api._
import com.typesafe.scalalogging._
import play.api.mvc.RequestHeader
import play.api.mvc.Handler

object Global extends GlobalSettings with LazyLogging {

  override def onStart(app: Application) {
    logger.info("Application has started")
  }

  override def onStop(app: Application) {
    logger.info("Application shutdown...")
  }

  override def onRequestReceived(request: RequestHeader): (RequestHeader, Handler) = {
    logger.debug("Before request --->")
    super.onRequestReceived(request)
  }

}