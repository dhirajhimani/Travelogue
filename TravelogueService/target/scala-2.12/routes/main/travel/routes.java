
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018

package travel;

import router.RoutesPrefix;

public class routes {
  
  public static final travel.ReverseTripController TripController = new travel.ReverseTripController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final travel.javascript.ReverseTripController TripController = new travel.javascript.ReverseTripController(RoutesPrefix.byNamePrefix());
  }

}
