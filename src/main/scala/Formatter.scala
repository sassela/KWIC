/**
 * Created by abby on 18/12/15.
 */

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex.Match

object Formatter {
  val formatSectionLength = 30

  // TODO tidy me.
  def cleanString(text: String) : String = "[^a-z\\s']+".r replaceAllIn(text.toLowerCase, "")

  // TODO move to Keywordfinder
  def getMatched(textLine: String, keyword: String) : Iterator[Match] = {
    keyword.r findAllMatchIn cleanString(textLine)
  }

  def rightJustify(textLine: String, matchedKeyword: Match) : String = {
    if (matchedKeyword.start > formatSectionLength) {
      textLine.substring(matchedKeyword.start-formatSectionLength, matchedKeyword.start)
    } else {
      val precedingText = textLine.substring(0, matchedKeyword.start)
      "%"+formatSectionLength+"s" format precedingText
    }
  }

  def leftJustify(textLine: String, matchedKeyword: Match) : String = {
    if (matchedKeyword.end+formatSectionLength < textLine.length) {
      textLine.substring(matchedKeyword.end, matchedKeyword.end+formatSectionLength)
    } else {
      val followingText = textLine.substring(matchedKeyword.end)
      "%-"+formatSectionLength+"s" format followingText
    }
  }

  def formatLine(lineNo: Int, textLine: String, keyword: String) = {
    val matched = getMatched(textLine, keyword)
    val sentences = new ListBuffer[String]

    matched.foreach { matchedKeyword => {
        sentences += ("%03d " format lineNo) + rightJustify(textLine, matchedKeyword) + (" %s" format keyword) + leftJustify(textLine, matchedKeyword)
      }
    }
    sentences.toList
  }
}
