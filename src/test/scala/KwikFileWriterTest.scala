/**
 * Created by abby on 19/12/15.
 */
import org.scalatest._

class KwikFileWriterTest extends FlatSpec {

  "write" should "add formatted contents to a file" in {
    KwikFileWriter.write("mapperTestFile.txt", "test-kwik-file.txt")
    assert(KwikFileReader.read("test-kwik-file.txt") == KwikFileReader.read("test-kwik-file-correct-output.txt"))
  }

}


