/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class FormatterTest extends FlatSpec {

  "cleanString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {

    assert(Formatter.cleanString("Hello, panda.") == "hello panda")
    assert(Formatter.cleanString("A beautiful cocktail table book full of beautiful photos of China and Pandas.") ==
      "a beautiful cocktail table book full of beautiful photos of china and pandas")
    assert(Formatter.cleanString("sËØOm8E947. €π4∫Ÿ ~ÌΩdeCIp8HeËØrAble 7tEx∂ƒt!") == "some decipherable text")
  }

//  "rightJustify" should "print, right justified, up to 30 characters preceding the keyword" in {
//
//  }
//
//  "leftJustify" should "print, left justified, up to 30 characters following the keyword" in {
//
//  }
//
//  "formatString" should "lowercase all words and remove all digits and all punctuation except apostrophes" in {
//
//  }


}

