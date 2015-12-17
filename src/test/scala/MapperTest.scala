/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class MapperTest extends FlatSpec {

  "map" should "parse list of strings into a map of keywords and line numbers" in {

    val fileText = KwikFileReader.read("mapperTestFile.txt")

    assert(Map("beautiful" -> List(4), "book" -> List(4), "brown" -> List(2), "china" -> List(4), "cocktail" -> List(4),
      "fox" -> List(2), "jumped" -> List(2), "lazy" -> List(2), "panda" -> List(1, 2), "pandas." -> List(4),
      "photos" -> List(4), "quick" -> List(2), "table" -> List(4), "ukdtyirsdtliviy" -> List(1)) == Mapper.map(fileText))
  }

}

