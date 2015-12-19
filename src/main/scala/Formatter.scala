/**
 * Created by abby on 18/12/15.
 */

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex.Match

object Formatter {
  // TODO tidy me.

  def cleanString(text: String) : String = "[^a-z\\s']+".r replaceAllIn(text.toLowerCase, "")

  def getMatched(textLine: String, keyword: String) : Iterator[Match] = {
    keyword.r findAllMatchIn cleanString(textLine)
  }

  def rightJustify(textLine: String, keyword: String) = {
    val matched = getMatched(textLine, keyword)
    val sentences = new ListBuffer[String]

    matched.foreach { sentence =>
      if (sentence.start > 30) {
        sentences += textLine.substring(sentence.start-30, sentence.start)
      } else {
        val precedingText = textLine.substring(0, sentence.start)
        sentences += (" " * (30 - precedingText.length)) + precedingText
      }
    }

    sentences.toList
  }
}
