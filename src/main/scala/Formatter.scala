/**
 * Created by abby on 18/12/15.
 */
object Formatter {

  def cleanString(text: String) : String = "[^a-z\\s']+".r replaceAllIn(text.toLowerCase, "")

}
