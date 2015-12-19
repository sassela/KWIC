import java.io.{PrintWriter, File}

/**
 * Created by abby on 19/12/15.
 */
object KwikFileWriter {

  // writer function from Keith Mannock testio.scala snippet
  def write(fromFileName: String, toFileName: String) {
    val file = new File(toFileName)
    val writer = new PrintWriter(file)
    writer write Formatter.formatFile(fromFileName)
    writer.close()

  }

}
