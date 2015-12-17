/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class MapperTest extends FlatSpec {

  "map" should "parse list of strings into a map of keywords and line numbers" in {

    val fileText = KwikFileReader.read("mapperTestFile.txt")

    assert(Map("panda" -> List(1, 2), "ukdtyirsdtliviy" -> List(1),
      "quick" -> List(2), "brown" -> List(2), "fox" -> List(2), "jumped" -> List(2), "lazy" -> List(2),
      "beautiful" -> List (4), "cocktail" -> List (4), "table" -> List (4), "book" -> List (4),
      "photos" -> List (4), "china" -> List (4), "pandas"-> List(4)) == Mapper.map(fileText))

//    assert(Map(1 -> List("panda", "ukdtyirsdtliviy"),
//      2 -> List("quick", "brown", "fox", "jumped", "lazy", "panda"),
//      4 -> List("beautiful", "cocktail", "table", "book", "beautiful", "photos", "china",
//        "pandas.")) == Mapper.map(fileText)) //TODO string cleaner
  }

}

