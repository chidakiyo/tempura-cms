package controllers

import play.api._
import play.api.mvc._
import org.apache.velocity.VelocityContext
import java.io.StringWriter
import org.apache.velocity.app.Velocity

object Application extends Controller {

  def index = Action {

    Velocity.init()

    val context = new VelocityContext()

    context.put("aaa", "AA_value")
    context.put("bbb", "BB_value")

    val writer = new StringWriter()

    Velocity.evaluate(context, writer, "", "hello ${aaa}${bbb}");

    val html = """<b>Test no escape</b> <- bold"""
    Ok(views.html.index(writer.toString))
  }

}