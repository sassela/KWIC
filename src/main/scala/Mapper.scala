import scala.collection.{mutable, SortedMap}

/**
 * Created by abby on 16/12/15.
 */

object Mapper {

  def map(textLines: List[String]) : SortedMap[String, List[Int]] = {
    val keywordsMap = scala.collection.mutable.LinkedHashMap[String, List[Int]]()

    // TODO tidy up...
    for ((line, i) <- textLines.zipWithIndex) {
      val lineNum = i+1
      if (KeywordFinder.getKeywords(line).nonEmpty) {
        for (keyword <- KeywordFinder.getKeywords(line)) {
          if (keywordsMap.contains(keyword) && !keywordsMap(keyword).contains(lineNum)) {
            keywordsMap(keyword) = keywordsMap(keyword) :+ lineNum
          } else keywordsMap += keyword -> List(lineNum)
        }
      }
    }
    SortedMap.empty[String, List[Int]] ++ keywordsMap
  }

}
