package controllers

import models.Vocabulary
import play.api.mvc._
import play.api.i18n.Lang
import services.VocabularyService
import javax.inject.Inject

class Import @Inject() (vocabulary: VocabularyService) extends Controller {
  def importWord(sourceLanguage: Lang, word: String, targetLanguage: Lang, translation: String) = Action { request =>
    val added = vocabulary.addVocabulary(Vocabulary(sourceLanguage, targetLanguage, word, translation))
    if (added) {
      Ok
    } else {
      Conflict
    }

  }
}