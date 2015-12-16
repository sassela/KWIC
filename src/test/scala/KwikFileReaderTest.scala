/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._
import scala.io.Source

class KwikFileReaderTest extends FlatSpec {

  "KwikFileReader" should "add contents from a file to a val" in {
    val fileContents = KwikFileReader.read("testFile.txt")
    assert(fileContents == List("test string"), "fileContents is not empty")
  }

}
