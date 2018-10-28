
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

package auth;

import router.RoutesPrefix;

public class routes {
  
  public static final auth.ReverseUserController UserController = new auth.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final auth.javascript.ReverseUserController UserController = new auth.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}
