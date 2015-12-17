import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * Created by abby on 16/12/15.
 */

object Mapper {
  val stopWords = KwikFileReader.read("stop_words.txt")

  def isKeyword(word: String) : Boolean = {
    for (stopWord <- stopWords) {
      if (word == stopWord) return false
    }
    true
  }
  
  def getKeywords(textLine: String) : List[String] = {
    val words = textLine.toLowerCase.split(" ") // TODO string cleaning method
    val keywords = new ListBuffer[String]()

    for (word <- words) {
      if (isKeyword(word)) keywords += word
    }
    keywords.toList
  }

  def map(textLines: List[String]) : mutable.LinkedHashMap[Int, List[String]] = {
    val keywordsMap = scala.collection.mutable.LinkedHashMap[Int, List[String]]()

    for ((line, lineNum) <- textLines.zipWithIndex) {
      if (getKeywords(line).nonEmpty) keywordsMap += lineNum + 1 -> getKeywords(line)
    }
    keywordsMap
  }

}
