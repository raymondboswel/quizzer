
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/git/Quizzer/conf/routes
// @DATE:Sun Oct 18 18:29:56 CAT 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.binders.PathBinders._

// @LINE:1
package controllers {

  // @LINE:2
  class ReverseImport(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def importWord(sourceLang:play.api.i18n.Lang, word:String, targetLang:play.api.i18n.Lang, translation:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "import/word/" + implicitly[PathBindable[play.api.i18n.Lang]].unbind("sourceLang", sourceLang) + "/" + implicitly[PathBindable[String]].unbind("word", dynamicString(word)) + "/" + implicitly[PathBindable[play.api.i18n.Lang]].unbind("targetLang", targetLang) + "/" + implicitly[PathBindable[String]].unbind("translation", dynamicString(translation)))
    }
  
  }

  // @LINE:1
  class ReverseTest(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def testAction(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "test")
    }
  
  }

  // @LINE:3
  class ReverseQuizz(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def quizz(sourceLang:play.api.i18n.Lang, targetLang:play.api.i18n.Lang): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "quizz/" + implicitly[PathBindable[play.api.i18n.Lang]].unbind("sourceLang", sourceLang) + "/" + implicitly[PathBindable[play.api.i18n.Lang]].unbind("targetLang", targetLang))
    }
  
  }


}