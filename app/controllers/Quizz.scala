package controllers

import javax.inject.Inject

import actors.QuizzActor
import akka.actor.ActorRef
import play.api.i18n.Lang
import play.api.mvc.{WebSocket, Action, Controller}
import services.VocabularyService
import models.Vocabulary

class Quizz @Inject() (vocabulary: VocabularyService) extends Controller {
  def quizz(sourceLanguage: Lang, targetLanguage: Lang) = Action {
    val randomWordOp: Option[Vocabulary] = vocabulary.findRandomVocabulary(sourceLanguage, targetLanguage)
    randomWordOp.map { v =>
      Ok(v.word)
    }.getOrElse(NotFound)
  }

  def check(sourceLanguage: Lang, word: String, targetLanguage: Lang, translation: String) = Action {
    val isCorrect = vocabulary.verify(sourceLanguage, word, targetLanguage, translation)
    if (isCorrect) {
      Ok
    } else {
      NotAcceptable
    }
  }

  def quizzEndpoint(sourceLang: Lang, targetLang: Lang) =
    WebSocket.acceptWithActor[String, String] { request =>
      (out: ActorRef) => QuizzActor.props(sourceLang, targetLang, out, vocabulary)
  }

}