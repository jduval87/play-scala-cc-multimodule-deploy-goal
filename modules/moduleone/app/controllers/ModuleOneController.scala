package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import play.api.libs.ws.WSClient
import play.api.mvc.{AbstractController, ControllerComponents}
import utils.GreetingsHelper

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class ModuleOneController @Inject() (
                                      cc: ControllerComponents,
                                      ws: WSClient
                                    )
                                    (implicit ec: ExecutionContext) extends AbstractController(cc) {
  def hello = Action {
    Ok(GreetingsHelper.greet("from module one"))
  }

  def userAgent = Action.async {
    ws.url("https://httpbin.org/user-agent").get().map { response =>
      Ok(response.body)
    }
  }
}
