package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {

    val html = """<b>Test no escape</b> <- bold"""
    Ok(views.html.index(html))
  }

}