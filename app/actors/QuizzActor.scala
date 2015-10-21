package actors

import akka.actor.{Props, Actor, ActorRef}
import play.api.i18n.Lang
import services.VocabularyService

/**
 * Created by Ray on 10/21/2015.
 */
class QuizzActor (out: ActorRef,
                 sourceLang: Lang,
                 targetLang: Lang,
                 vocabulary: VocabularyService )
extends Actor{

  private var word = ""

  override def preStart(): Unit = sendWord()

  def receive = {
    case translation: String
      if vocabulary.verify(sourceLang, word, targetLang, translation)
      => out ! "Correct!"
      sendWord()
    case _ =>
      out ! "Incorrect, try again!"
  }

  def sendWord() = {
    vocabulary.findRandomVocabulary(sourceLang, targetLang).map { v =>
      out ! s"Please translate '${v.word}'"
      word = v.word
    }.getOrElse( out ! s"I don't know any word for ${sourceLang.code} and ${targetLang.code}"
   )
  }

}
object QuizzActor {
  def props(sourceLang: Lang, targetLang: Lang, out: ActorRef, vocabulary: VocabularyService): Props =
    Props(classOf[QuizzActor], out, sourceLang, targetLang)
}
