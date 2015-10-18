
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/git/Quizzer/conf/routes
// @DATE:Sun Oct 18 18:29:56 CAT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.binders.PathBinders._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Test_1: controllers.Test,
  // @LINE:2
  Import_0: controllers.Import,
  // @LINE:3
  Quizz_2: controllers.Quizz,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Test_1: controllers.Test,
    // @LINE:2
    Import_0: controllers.Import,
    // @LINE:3
    Quizz_2: controllers.Quizz
  ) = this(errorHandler, Test_1, Import_0, Quizz_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Test_1, Import_0, Quizz_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """controllers.Test.testAction"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """import/word/$sourceLang<[^/]+>/$word<[^/]+>/$targetLang<[^/]+>/$translation<[^/]+>""", """controllers.Import.importWord(sourceLang:play.api.i18n.Lang, word:String, targetLang:play.api.i18n.Lang, translation:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """quizz/$sourceLang<[^/]+>/$targetLang<[^/]+>""", """controllers.Quizz.quizz(sourceLang:play.api.i18n.Lang, targetLang:play.api.i18n.Lang)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_Test_testAction0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_Test_testAction0_invoker = createInvoker(
    Test_1.testAction,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Test",
      "testAction",
      Nil,
      "GET",
      """""",
      this.prefix + """test"""
    )
  )

  // @LINE:2
  private[this] lazy val controllers_Import_importWord1_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("import/word/"), DynamicPart("sourceLang", """[^/]+""",true), StaticPart("/"), DynamicPart("word", """[^/]+""",true), StaticPart("/"), DynamicPart("targetLang", """[^/]+""",true), StaticPart("/"), DynamicPart("translation", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Import_importWord1_invoker = createInvoker(
    Import_0.importWord(fakeValue[play.api.i18n.Lang], fakeValue[String], fakeValue[play.api.i18n.Lang], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Import",
      "importWord",
      Seq(classOf[play.api.i18n.Lang], classOf[String], classOf[play.api.i18n.Lang], classOf[String]),
      "PUT",
      """""",
      this.prefix + """import/word/$sourceLang<[^/]+>/$word<[^/]+>/$targetLang<[^/]+>/$translation<[^/]+>"""
    )
  )

  // @LINE:3
  private[this] lazy val controllers_Quizz_quizz2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("quizz/"), DynamicPart("sourceLang", """[^/]+""",true), StaticPart("/"), DynamicPart("targetLang", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Quizz_quizz2_invoker = createInvoker(
    Quizz_2.quizz(fakeValue[play.api.i18n.Lang], fakeValue[play.api.i18n.Lang]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Quizz",
      "quizz",
      Seq(classOf[play.api.i18n.Lang], classOf[play.api.i18n.Lang]),
      "GET",
      """""",
      this.prefix + """quizz/$sourceLang<[^/]+>/$targetLang<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_Test_testAction0_route(params) =>
      call { 
        controllers_Test_testAction0_invoker.call(Test_1.testAction)
      }
  
    // @LINE:2
    case controllers_Import_importWord1_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromPath[String]("word", None), params.fromPath[play.api.i18n.Lang]("targetLang", None), params.fromPath[String]("translation", None)) { (sourceLang, word, targetLang, translation) =>
        controllers_Import_importWord1_invoker.call(Import_0.importWord(sourceLang, word, targetLang, translation))
      }
  
    // @LINE:3
    case controllers_Quizz_quizz2_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromPath[play.api.i18n.Lang]("targetLang", None)) { (sourceLang, targetLang) =>
        controllers_Quizz_quizz2_invoker.call(Quizz_2.quizz(sourceLang, targetLang))
      }
  }
}