import scala.collection.mutable.ListBuffer

/**
 * Created by abby on 17/12/15.
 */
object KeywordFinder {
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

}
