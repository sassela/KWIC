/**
 * Created by abby on 18/12/15.
 */

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex.Match

object Formatter {
  val formatSectionLength = 30

  // TODO tidy me.

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
    val keywordMatches = KeywordFinder.getKeywordMatches(textLine, keyword)
    val sentences = new ListBuffer[String]

    keywordMatches.foreach { keywordMatch => {
        sentences += ("%03d " format lineNo) + rightJustify(textLine, keywordMatch) + (" %s" format keyword) + leftJustify(textLine, keywordMatch)
      }
    }
    sentences.toList
  }

  // TODO write some tests
  def formatFile(fromFileName: String) = {
    val fileLines = KwikFileReader.read(fromFileName)
    val keywordsMap = Mapper.map(fileLines)
    val formattedFile = new StringBuilder()

    keywordsMap.foreach{ case (key, value) =>

      value.foreach { lineNum =>
        val lines = formatLine(lineNum, fileLines(lineNum-1), key)
        lines.foreach { line =>
          formattedFile.append(line+"\n")
        }
      }
    }

    formattedFile.mkString
  }
}
