/**
 * Created by abby on 13/12/15.
 */
import org.scalatest._
import scala.io.Source

class TestKwikFileReader extends FlatSpec {

  "KwikFileReader" should "add contents from a file to a val" in {
    val source = Source.fromURL(getClass.getResource("testFile.txt"))
    val fileContents = KwikFileReader.read(source)
    assert(fileContents == List("test string"), "fileContents is not empty")
  }

}
