/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class FormatterTest extends FlatSpec {
  val pandaText = "A beautiful cocktail table book full of beautiful photos of China and Pandas."

  "cleanString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {

    assert(Formatter.cleanString("Hello, panda.") == "hello panda")
    assert(Formatter.cleanString(pandaText) == "a beautiful cocktail table book full of beautiful photos of china and" +
      " pandas")
    assert(Formatter.cleanString("sËØOm8E947. €π4∫Ÿ~ÌΩdeCIp8HeËØrAble 7tEx∂ƒt!") == "some decipherable text")
  }

  "rightJustify" should "return a list of string(s), right justified, up to 30 characters preceding the keyword(s)" in {

    assert(Formatter.rightJustify(pandaText, Formatter.getMatched(pandaText,"pandas").next()) == ("%30s" format "beautiful photos of China and "))
    assert(Formatter.rightJustify(pandaText, Formatter.getMatched(pandaText,"beautiful").next()) == ("%30s" format "A "))
    assert(Formatter.rightJustify(pandaText, Formatter.getMatched(pandaText,"table").next()) == ("%30s" format "A beautiful cocktail "))
  }

  "leftJustify" should "return a list of string(s), left justified, up to 30 characters following the keyword(s)" in {
    assert(Formatter.leftJustify(pandaText, Formatter.getMatched(pandaText,"pandas").next()) == ("%-30s" format "."))
    assert(Formatter.leftJustify(pandaText, Formatter.getMatched(pandaText,"beautiful").next()) == ("%-30s" format " cocktail table book full of b"))
    assert(Formatter.leftJustify(pandaText, Formatter.getMatched(pandaText,"china").next()) == ("%-30s" format " and Pandas."))

  }

//  "formatString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {
//
//  }


}

