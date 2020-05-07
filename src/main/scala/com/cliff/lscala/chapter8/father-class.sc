
abstract class BulkReader {
  type In
  val source: In

  def read: String
}

class StringBulkReader(val source: String) extends BulkReader {
  type In = String

  def read: String = source
}

import java.io.{BufferedInputStream, File, FileInputStream}

class FileBulkReader(val source: File) extends BulkReader {
  type In = File

  def read: String = {
    val inputStream = new BufferedInputStream(new FileInputStream(source))
    val numBytes = inputStream.available()
    val bytes = new Array[Byte](numBytes)
    inputStream.read(bytes)
    new String(bytes)
  }

}