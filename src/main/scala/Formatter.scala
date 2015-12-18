/**
 * Created by abby on 18/12/15.
 */
object Formatter {

  def cleanString(text: String) : String = text.toLowerCase.replaceAll("[^a-z\\s']+", "")

}
