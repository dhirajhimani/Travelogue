
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package auth.javascript {

  // @LINE:1
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "auth.UserController.delete",
      """
        function(user_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/auth/delete" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("user_id", user_id0)])})
        }
      """
    )
  
    // @LINE:4
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "auth.UserController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/auth/users"})
        }
      """
    )
  
    // @LINE:1
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "auth.UserController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/auth/register"})
        }
      """
    )
  
    // @LINE:3
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "auth.UserController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/auth/update"})
        }
      """
    )
  
    // @LINE:2
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "auth.UserController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/auth/login"})
        }
      """
    )
  
  }


}
