
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/git/Quizzer/conf/routes
// @DATE:Sun Oct 18 18:29:56 CAT 2015


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
