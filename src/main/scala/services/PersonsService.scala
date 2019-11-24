package services

import com.twitter.finagle.{Service, http}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Future

object PersonsService {
  val json =
    """
      |{
      |   "person": {
      |     "name": "Thomas Vogel",
      |     "age": 32
      |   }
      |}
      |""".stripMargin

  val personsService = new Service[http.Request, http.Response] {
    override def apply(request: Request): Future[Response] = {

      val response = Response(http.Status.Ok)
      response.setContentString(json)
      response.setContentTypeJson()

      Future.value(response)
    }
  }
}
