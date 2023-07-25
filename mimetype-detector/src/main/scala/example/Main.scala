package example

import org.apache.tika.Tika

import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object Main extends  App {
  def getPathsInDir(dir: String): List[String] = {
    val paths = Files.walk(Path.of(dir)).iterator().asScala.toList
      .filter(f => Files.isRegularFile(f))
      .map(f => f.toAbsolutePath.toString)
    paths
  }

  def getMimeType(filename: String): String = {
    val tika = new Tika()
    tika.detect(filename)
  }

  val sourceDirectory = args(0)
  val allFiles = getPathsInDir(sourceDirectory)
  val allMimeTypes = allFiles.map(f => getMimeType(f))
  println("")
  println(s"Directory: $sourceDirectory")
  println("-------------------------------")

  val allMimeTypesWithCounts = allMimeTypes.groupBy(identity).view.mapValues(_.size).toMap
  allMimeTypesWithCounts.foreach{ case (mimetype, count) => println(s"$mimetype: $count")}

  println("")
  println(s"Total mimetypes: ${allMimeTypes.toSet.size}")

}
