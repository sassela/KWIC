import org.scalatest.FlatSpec

/**
 * Created by abby on 17/12/15.
 */
class KeywordFinderTest extends FlatSpec  {

  "isKeyword" should "return boolean value corresponding to non stop-word" in {

    assert(!KeywordFinder.isKeyword("a"))
    assert(!KeywordFinder.isKeyword("sensible"))
    assert(KeywordFinder.isKeyword("panda"))
    assert(KeywordFinder.isKeyword("ukdtyirsdtliviy"))
  }

  "getKeywords" should "return all keywords for a given string" in {

    assert(List("quick", "brown", "fox", "jumped", "lazy", "panda") == KeywordFinder.getKeywords("the quick brown fox " +
      "jumped over the lazy panda"))
    assert(List() == KeywordFinder.getKeywords("during a ourselves nonetheless zero"))
  }

}
