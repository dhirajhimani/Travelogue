
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dhirajh/Documents/Codes/Toptal/TravelogueService/conf/routes
// @DATE:Thu Oct 11 10:37:09 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
