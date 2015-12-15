/**
 * Created by abby on 02/12/15.
 */

import scala.io.BufferedSource

object KwikFileReader {
  def read(filename: BufferedSource) = {
    // TODO avoid dupe filelines...
    val fileLines = filename.getLines().toList
    fileLines
  }

  def main(args: Array[String]) {
    println("Not doing much yet.")
  }
}