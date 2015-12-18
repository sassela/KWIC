import scala.collection.mutable.ListBuffer

/**
 * Created by abby on 17/12/15.
 */
object KeywordFinder {

  def isKeyword(word: String) : Boolean = {
    val stopWords = KwikFileReader.read("stop_words.txt")

    for (stopWord <- stopWords) {
      if (word == stopWord) return false
    }
    true
  }

  def getKeywords(textLine: String) : List[String] = {
    val words = Formatter.cleanString(textLine).split(" ")
    val keywords = new ListBuffer[String]()

    for (word <- words) {
      if (isKeyword(word)) keywords += word
    }
    keywords.toList
  }

}
