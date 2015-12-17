/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class MapperTest extends FlatSpec {

  "isKeyword" should "return boolean value corresponding to non stop-word" in {
    
    assert(!Mapper.isKeyword("a"))
    assert(!Mapper.isKeyword("sensible"))
    assert(Mapper.isKeyword("panda"))
    assert(Mapper.isKeyword("ukdtyirsdtliviy"))
  }

  "getKeywords" should "return all keywords for a given string" in {

    assert(List("quick", "brown", "fox", "jumped", "lazy", "panda") == Mapper.getKeywords("the quick brown fox " +
      "jumped over the lazy panda"))
    assert(List() == Mapper.getKeywords("during a ourselves nonetheless zero"))
  }

  "map" should "parse list of strings into a map of line numbers and keywords" in {

    val fileText = KwikFileReader.read("mapperTestFile.txt")
    assert(Map(1 -> List("panda", "ukdtyirsdtliviy"),
      2 -> List("quick", "brown", "fox", "jumped", "lazy", "panda"),
      4 -> List("beautiful", "cocktail", "table", "book", "full", "beautiful", "photos", "China",
        "Pandas")) == Mapper.map(fileText))
  }

}

