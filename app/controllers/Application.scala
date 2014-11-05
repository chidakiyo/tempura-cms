package controllers

import play.api._
import play.api.mvc._
import org.apache.velocity.VelocityContext
import java.io.StringWriter
import org.apache.velocity.app.Velocity

object Application extends Controller {

  def index = Action {

    val context = new VelocityContext()

    context.put("aaa", "AA_value")
    context.put("bbb", "BB_value")

    val writer = new StringWriter()

    Velocity.evaluate(context, writer, "", "hello ${aaa}${bbb}");

    // sclikejdbc-test
    import scalikejdbc._
    implicit val session = AutoSession

    Seq("Alice", "Bob", "Chris") foreach { name =>
      sql"insert into members (name, created_at) values (${name}, current_timestamp)".update.apply()
    }

    Ok(views.html.index(writer.toString))
  }

  def article(id: String) = Action {
    val html = """<b>Test no escape</b> <- bold"""
    Ok(views.html.index(html))
  }

}