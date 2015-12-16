/**
 * Created by abby on 02/12/15.
 */

import scala.io.Source

object KwikFileReader {
  def read(filename: String) : List[String] = {
    val file = Source.fromURL(getClass.getResource(filename))
    file.getLines().toList
  }
}