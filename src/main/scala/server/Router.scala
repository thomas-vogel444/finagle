package server

import com.twitter.finagle.http.{Method, Request}
import com.twitter.finagle.http.service.RoutingService
import services.{ErrorServices, PersonsService}

object Router {
  val routingService: RoutingService[Request] =
    RoutingService.byMethodAndPath {
      case (Method.Get, "/persons") => PersonsService.personsService
      case _                        => ErrorServices.badRequestService
    }
}
