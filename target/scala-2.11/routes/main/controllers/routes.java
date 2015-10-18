
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/git/Quizzer/conf/routes
// @DATE:Sun Oct 18 18:29:56 CAT 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseImport Import = new controllers.ReverseImport(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTest Test = new controllers.ReverseTest(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQuizz Quizz = new controllers.ReverseQuizz(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseImport Import = new controllers.javascript.ReverseImport(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTest Test = new controllers.javascript.ReverseTest(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQuizz Quizz = new controllers.javascript.ReverseQuizz(RoutesPrefix.byNamePrefix());
  }

}
