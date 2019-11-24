package server

import com.twitter.finagle.http.{Method, Request, Response, Status}
import com.twitter.util.Await
import org.scalatest.{Matchers, WordSpec}

class RouterTest extends WordSpec with Matchers {

  "/persons" should {
    "return a 200 Ok with the details of Thomas Vogel" in {

      val request = Request(Method.Get, "/persons")

      val response: Response = Await.result(Router.routingService(request))

      response.status shouldBe Status.Ok
    }
  }

}
