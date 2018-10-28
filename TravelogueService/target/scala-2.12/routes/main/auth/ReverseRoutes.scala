
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package auth {

  // @LINE:1
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def delete(user_id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/auth/delete" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("user_id", user_id)))))
    }
  
    // @LINE:4
    def getAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "v1/auth/users")
    }
  
    // @LINE:1
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/auth/register")
    }
  
    // @LINE:3
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/auth/update")
    }
  
    // @LINE:2
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "v1/auth/login")
    }
  
  }


}
