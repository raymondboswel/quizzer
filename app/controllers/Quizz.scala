package controllers

import javax.inject.Inject

import play.api.i18n.Lang
import play.api.mvc.{ Action, Controller }
import services.VocabularyService
import models.Vocabulary

class Quizz @Inject() (vocabulary: VocabularyService) extends Controller {
  def quizz(sourceLanguage: Lang, targetLanguage: Lang) = Action {
    val randomWordOp: Option[Vocabulary] = vocabulary.findRandomVocabulary(sourceLanguage, targetLanguage)
    randomWordOp.map { v =>
      Ok(v.word)
    }.getOrElse(NotFound)
  }

}