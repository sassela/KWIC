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

//  "getKeywords" should "return all keywords for a given string" in {
//
//  }
//
//  "map" should "parse list of strings into a map of keywords and line numbers" in {
//
//  }

}

