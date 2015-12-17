/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class MapperTest extends FlatSpec {

  "map" should "parse list of strings into a map of line numbers and keywords" in {

    val fileText = KwikFileReader.read("mapperTestFile.txt")
    assert(Map(1 -> List("panda", "ukdtyirsdtliviy"),
      2 -> List("quick", "brown", "fox", "jumped", "lazy", "panda"),
      4 -> List("beautiful", "cocktail", "table", "book", "beautiful", "photos", "china",
        "pandas.")) == Mapper.map(fileText)) //TODO string cleaner
  }

}

