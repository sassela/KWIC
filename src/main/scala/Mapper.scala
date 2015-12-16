/**
 * Created by abby on 16/12/15.
 */

object Mapper {
  val stopWords = KwikFileReader.read("stop_words.txt")

  def isKeyword(text: String) : Boolean = {
    for (word <- stopWords) {
      if (text == word) return false
    }
    true
  }

}
