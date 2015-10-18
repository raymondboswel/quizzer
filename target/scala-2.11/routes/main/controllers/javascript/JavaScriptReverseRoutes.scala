
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/git/Quizzer/conf/routes
// @DATE:Sun Oct 18 18:29:56 CAT 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.binders.PathBinders._

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:2
  class ReverseImport(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def importWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Import.importWord",
      """
        function(sourceLang,word,targetLang,translation) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "import/word/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("word", encodeURIComponent(word)) + "/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("translation", encodeURIComponent(translation))})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseTest(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def testAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Test.testAction",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
        }
      """
    )
  
  }

  // @LINE:3
  class ReverseQuizz(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def quizz: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Quizz.quizz",
      """
        function(sourceLang,targetLang) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quizz/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + "/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang)})
        }
      """
    )
  
  }


}