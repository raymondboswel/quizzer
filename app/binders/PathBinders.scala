package binders

import play.api.i18n.Lang
import play.api.mvc.PathBindable
import play.api.mvc.QueryStringBindable

/**
 * Created by Ray on 10/18/2015.
 */
object PathBinders {

  implicit object LangPathBindable extends PathBindable[Lang] {
    override def bind(key: String, value: String): Either[String, Lang] =
      Lang.get(value).toRight(s"Language $value is not recognized")
    override def unbind(key: String, value: Lang): String = value.code

  }

  implicit object LangQueryStringBinder extends QueryStringBindable[Lang] {
    override def bind(key: String, params: Map[String, Seq[String]]): Option[Either[String, Lang]] = {
      params.get(key).map {
        v =>
          val data = v
          val langCode = data.head
          Lang.get(langCode).toRight(s"Language $langCode is not recognized")
      }

    }

    override def unbind(key: String, value: Lang): String = value.code
  }

}
