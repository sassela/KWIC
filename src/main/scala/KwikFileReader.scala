/**
 * Created by abby on 02/12/15.
 */

import scala.io.{Source, BufferedSource}

object KwikFileReader {
  def read(filename: String) = {

    // TODO Simplify avoid dupe filelines...
    val source = Source.fromURL(getClass.getResource(filename))
    val fileLines = source.getLines().toList
    fileLines
  }
}