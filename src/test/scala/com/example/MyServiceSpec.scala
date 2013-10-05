package com.example

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class MyServiceSpec extends Specification with Specs2RouteTest with MyService {
  def actorRefFactory = system
  
  "MyService" should {

    "echo the echo query param for a get" in {
      Get("/v1?echo=thing") ~> myRoute ~> check {
        entityAs[String] must contain("thing")
      }
    }

//    "return a MethodNotAllowed error for PUT requests to the root path" in {
//      Put() ~> sealRoute(myRoute) ~> check {
//        status === MethodNotAllowed
//        entityAs[String] === "HTTP method not allowed, supported methods: GET"
//      }
//    }
  }
}