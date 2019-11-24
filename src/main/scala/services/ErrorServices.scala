package services

import com.twitter.finagle.{Service, http}
import com.twitter.finagle.http.Response
import com.twitter.util.Future

object ErrorServices {
  val badRequestService = {
    val response = Response(http.Status.BadRequest)
    response.setContentString(
      """
        |{
        |   "error": "This page does not exist"
        |}
        |""".stripMargin
    )

    Service.constant(Future.value(response))
  }
}