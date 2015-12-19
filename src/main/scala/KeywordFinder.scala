import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex.Match

/**
 * Created by abby on 17/12/15.
 */
object KeywordFinder {

  def cleanString(text: String) : String = "[^a-z\\s']+".r replaceAllIn(text.toLowerCase, "")

  def isKeyword(word: String) : Boolean = {
    val stopWords = KwikFileReader.read("stop_words.txt")

    for (stopWord <- stopWords) {
      if (word == stopWord) return false
    }
    true
  }

  def getKeywords(textLine: String) : List[String] = {
    val words = cleanString(textLine).split(" ")
    val keywords = new ListBuffer[String]()

    for (word <- words) {
      if (isKeyword(word)) keywords += word
    }
    keywords.toList
  }

  // TODO write tests
  def getKeywordMatches(textLine: String, keyword: String) : Iterator[Match] = {
    keyword.r findAllMatchIn cleanString(textLine)
  }

}
