package server

import com.twitter.finagle.Http
import com.twitter.util.Await

object PersonServer {
  def main(args: Array[String]): Unit = {
    Await.ready(Http.serve(":8080", Router.routingService))
  }
}
