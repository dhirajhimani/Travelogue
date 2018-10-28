
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  UserController_1: auth.UserController,
  // @LINE:7
  TripController_0: travel.TripController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    UserController_1: auth.UserController,
    // @LINE:7
    TripController_0: travel.TripController
  ) = this(errorHandler, UserController_1, TripController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_1, TripController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/auth/register""", """auth.UserController.register"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/auth/login""", """auth.UserController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/auth/update""", """auth.UserController.update"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/auth/users""", """auth.UserController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/auth/delete""", """auth.UserController.delete(user_id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/travel/addtrip""", """travel.TripController.addTrip"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/travel/update""", """travel.TripController.updateTrip"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/travel/trips""", """travel.TripController.getTrips(user_id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/travel/delete""", """travel.TripController.deleteTrip(trip_id:Int)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val auth_UserController_register0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/auth/register")))
  )
  private[this] lazy val auth_UserController_register0_invoker = createInvoker(
    UserController_1.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "auth.UserController",
      "register",
      Nil,
      "POST",
      this.prefix + """v1/auth/register""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val auth_UserController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/auth/login")))
  )
  private[this] lazy val auth_UserController_login1_invoker = createInvoker(
    UserController_1.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "auth.UserController",
      "login",
      Nil,
      "POST",
      this.prefix + """v1/auth/login""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val auth_UserController_update2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/auth/update")))
  )
  private[this] lazy val auth_UserController_update2_invoker = createInvoker(
    UserController_1.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "auth.UserController",
      "update",
      Nil,
      "POST",
      this.prefix + """v1/auth/update""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val auth_UserController_getAll3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/auth/users")))
  )
  private[this] lazy val auth_UserController_getAll3_invoker = createInvoker(
    UserController_1.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "auth.UserController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """v1/auth/users""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val auth_UserController_delete4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/auth/delete")))
  )
  private[this] lazy val auth_UserController_delete4_invoker = createInvoker(
    UserController_1.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "auth.UserController",
      "delete",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """v1/auth/delete""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val travel_TripController_addTrip5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/travel/addtrip")))
  )
  private[this] lazy val travel_TripController_addTrip5_invoker = createInvoker(
    TripController_0.addTrip,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "travel.TripController",
      "addTrip",
      Nil,
      "POST",
      this.prefix + """v1/travel/addtrip""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val travel_TripController_updateTrip6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/travel/update")))
  )
  private[this] lazy val travel_TripController_updateTrip6_invoker = createInvoker(
    TripController_0.updateTrip,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "travel.TripController",
      "updateTrip",
      Nil,
      "POST",
      this.prefix + """v1/travel/update""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val travel_TripController_getTrips7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/travel/trips")))
  )
  private[this] lazy val travel_TripController_getTrips7_invoker = createInvoker(
    TripController_0.getTrips(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "travel.TripController",
      "getTrips",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """v1/travel/trips""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val travel_TripController_deleteTrip8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/travel/delete")))
  )
  private[this] lazy val travel_TripController_deleteTrip8_invoker = createInvoker(
    TripController_0.deleteTrip(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "travel.TripController",
      "deleteTrip",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """v1/travel/delete""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case auth_UserController_register0_route(params) =>
      call { 
        auth_UserController_register0_invoker.call(UserController_1.register)
      }
  
    // @LINE:2
    case auth_UserController_login1_route(params) =>
      call { 
        auth_UserController_login1_invoker.call(UserController_1.login)
      }
  
    // @LINE:3
    case auth_UserController_update2_route(params) =>
      call { 
        auth_UserController_update2_invoker.call(UserController_1.update)
      }
  
    // @LINE:4
    case auth_UserController_getAll3_route(params) =>
      call { 
        auth_UserController_getAll3_invoker.call(UserController_1.getAll)
      }
  
    // @LINE:5
    case auth_UserController_delete4_route(params) =>
      call(params.fromQuery[Int]("user_id", None)) { (user_id) =>
        auth_UserController_delete4_invoker.call(UserController_1.delete(user_id))
      }
  
    // @LINE:7
    case travel_TripController_addTrip5_route(params) =>
      call { 
        travel_TripController_addTrip5_invoker.call(TripController_0.addTrip)
      }
  
    // @LINE:8
    case travel_TripController_updateTrip6_route(params) =>
      call { 
        travel_TripController_updateTrip6_invoker.call(TripController_0.updateTrip)
      }
  
    // @LINE:9
    case travel_TripController_getTrips7_route(params) =>
      call(params.fromQuery[Int]("user_id", None)) { (user_id) =>
        travel_TripController_getTrips7_invoker.call(TripController_0.getTrips(user_id))
      }
  
    // @LINE:10
    case travel_TripController_deleteTrip8_route(params) =>
      call(params.fromQuery[Int]("trip_id", None)) { (trip_id) =>
        travel_TripController_deleteTrip8_invoker.call(TripController_0.deleteTrip(trip_id))
      }
  }
}
