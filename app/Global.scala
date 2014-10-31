import play.api._
import com.typesafe.scalalogging.LazyLogging

object Global extends GlobalSettings with LazyLogging {

  override def onStart(app: Application) {
    logger.info("Application has started")
  }

  override def onStop(app: Application) {
    logger.info("Application shutdown...")
  }

  override def onRequest(app: Application) {
    logger.info("######################")
  }

}