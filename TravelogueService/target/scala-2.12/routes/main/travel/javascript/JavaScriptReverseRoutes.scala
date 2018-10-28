
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package travel.javascript {

  // @LINE:7
  class ReverseTripController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def deleteTrip: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "travel.TripController.deleteTrip",
      """
        function(trip_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/travel/delete" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("trip_id", trip_id0)])})
        }
      """
    )
  
    // @LINE:9
    def getTrips: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "travel.TripController.getTrips",
      """
        function(user_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/travel/trips" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("user_id", user_id0)])})
        }
      """
    )
  
    // @LINE:8
    def updateTrip: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "travel.TripController.updateTrip",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/travel/update"})
        }
      """
    )
  
    // @LINE:7
    def addTrip: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "travel.TripController.addTrip",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/travel/addtrip"})
        }
      """
    )
  
  }


}
