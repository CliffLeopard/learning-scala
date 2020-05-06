import java.io.File

val path = "~/Downloads/2017-2018/"
val file = new File(path)
def rename(file: File): Unit = {
  file.listFiles withFilter (!_.isDirectory) foreach (
    file => {
      val fileName = file.getName
      if (fileName.endsWith(".mp4")) {
        val start = fileName.lastIndexOf('[')
        val end = fileName.lastIndexOf(']')
        val newName = fileName.substring(start, end+1) +
          fileName.substring(0, start-1) +
          fileName.substring(end+1)
//        file.renameTo(new File(file.getParent + "/" + newName))
      }
    })
  file.listFiles withFilter (_.isDirectory) foreach (rename(_))
}
rename(file)

