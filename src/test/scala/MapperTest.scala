/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class MapperTest extends FlatSpec {

  "isKeyWord" should "return boolean value corresponding to non stop-word" in {
    assert(Mapper.isKeyWord("a") == false)
    assert(Mapper.isKeyWord("sensible") == false)
    assert(Mapper.isKeyWord("panda") == true)
    assert(Mapper.isKeyWord("ukdtyirsdtliviyfodftktckudytd") == true)
  }

//  "getKeyWords" should "return all keywords for a given string" in {
//
//  }
//
//  "map" should "parse list of strings into a map of keywords and line numbers" in {
//
//  }

}

