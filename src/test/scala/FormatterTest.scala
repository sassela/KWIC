/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._

class FormatterTest extends FlatSpec {
  val pandaText = "A beautiful cocktail table book full of beautiful photos of China and Pandas."

  "rightJustify" should "return a string, right justified, up to 30 characters preceding the keyword(s)" in {

    assert(Formatter.rightJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"pandas").next()) ==
      ("%30s" format "beautiful photos of China and "))
    assert(Formatter.rightJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"beautiful").next()) == ("%30s" format "A "))
    assert(Formatter.rightJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"table").next()) ==
      ("%30s" format "A beautiful cocktail "))
  }

  "leftJustify" should "return a string, left justified, up to 30 characters following the keyword(s)" in {
    assert(Formatter.leftJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"pandas").next()) == ("%-30s" format "."))
    assert(Formatter.leftJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"beautiful").next()) ==
      ("%-30s" format " cocktail table book full of b"))
    assert(Formatter.leftJustify(pandaText, KeywordFinder.getKeywordMatches(pandaText,"china").next()) ==
      ("%-30s" format " and Pandas."))

  }

  "formatLine" should "return a list of formatted string(s)" in {
    assert(Formatter.formatLine(4, pandaText, "pandas") ==
      List("004 " + ("%30s" format "beautiful photos of China and ") + (" %s" format "pandas") + ("%-30s" format ".")))
    assert(Formatter.formatLine(4, pandaText, "beautiful") ==
      List("004 " + ("%30s" format "A ") + (" %s" format "beautiful") + ("%-30s" format " cocktail table book full of b"),
      "004 " + ("%30s" format "l cocktail table book full of ") + (" %s" format "beautiful") + ("%-30s" format  " photos of China and Pandas.")))
    assert(Formatter.formatLine(4, pandaText, "cocktail") == List("004 " + ("%30s" format "A beautiful ") +
      (" %s" format "cocktail") + ("%-30s" format  " table book full of beautiful ")))
  }


}

