import scala.collection.mutable

/**
 * Created by abby on 16/12/15.
 */

object Mapper {

  def map(textLines: List[String]) : mutable.LinkedHashMap[Int, List[String]] = {
    val keywordsMap = scala.collection.mutable.LinkedHashMap[Int, List[String]]()

    for ((line, lineNum) <- textLines.zipWithIndex) {
      if (KeywordFinder.getKeywords(line).nonEmpty) keywordsMap += lineNum + 1 -> KeywordFinder.getKeywords(line)
    }
    keywordsMap
  }

}
