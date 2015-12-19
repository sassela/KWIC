import org.scalatest.FlatSpec

/**
 * Created by abby on 17/12/15.
 */
class KeywordFinderTest extends FlatSpec  {

  "cleanString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {

    assert(KeywordFinder.cleanString("Hello, panda.") == "hello panda")
    assert(KeywordFinder.cleanString("A beautiful cocktail table book full of beautiful photos of China and Pandas.") ==
      "a beautiful cocktail table book full of beautiful photos of china and pandas")
    assert(KeywordFinder.cleanString("sËØOm8E947. €π4∫Ÿ~ÌΩdeCIp8HeËØrAble 7tEx∂ƒt!'") == "some decipherable text'")
  }

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
