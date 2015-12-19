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
    assert(Formatter.rightJustify(pandaText, "pandas") == List("beautiful photos of China and "))
    assert(Formatter.rightJustify(pandaText, "beautiful") == List("                            A ",
      "l cocktail table book full of "))
    assert(Formatter.rightJustify(pandaText, "table") == List("         A beautiful cocktail "))
  }

  "leftJustify" should "return a list of string(s), left justified, up to 30 characters following the keyword(s)" in {
    assert(Formatter.leftJustify(pandaText, "pandas") == List(".                             "))
    assert(Formatter.leftJustify(pandaText, "beautiful") == List(" cocktail table book full of b",
      " photos of China and Pandas.  "))
    assert(Formatter.leftJustify(pandaText, "china") == List(" and Pandas.                  "))

  }

//  "formatString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {
//
//  }


}

