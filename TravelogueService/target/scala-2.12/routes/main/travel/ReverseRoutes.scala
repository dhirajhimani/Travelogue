
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package travel {

  // @LINE:7
  class ReverseTripController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def deleteTrip(trip_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/travel/delete" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("trip_id", trip_id)))))
    }
  
    // @LINE:9
    def getTrips(user_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/travel/trips" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("user_id", user_id)))))
    }
  
    // @LINE:8
    def updateTrip(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/travel/update")
    }
  
    // @LINE:7
    def addTrip(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/travel/addtrip")
    }
  
  }


}
