package server

import com.twitter.finagle.Http
import com.twitter.finagle.http.Method
import com.twitter.finagle.http.service.RoutingService
import com.twitter.util.Await
import services.{ErrorServices, PersonsService}

object PersonServer {
  def main(args: Array[String]): Unit = {
    val routingService =
      RoutingService.byMethodAndPath {
        case (Method.Get, "/persons") => PersonsService.personsService
        case _                        => ErrorServices.badRequestService
      }

    val server = Http.serve(":8080", routingService)
    Await.ready(server)
  }
}
