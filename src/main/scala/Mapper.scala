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
  
  def getKeywords(text: String) : List[String] = {
    val words = text.split(" ")
    val keywords = new ListBuffer[String]()

    for (word <- words) {
      if (isKeyword(word)) keywords += word
    }
    keywords.toList
  }

}
