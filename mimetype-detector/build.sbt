import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "mimetype-detector",
    libraryDependencies += munit % Test,
    libraryDependencies += "org.apache.tika" % "tika-parsers" % "2.8.0",
    libraryDependencies += "org.apache.tika" % "tika-core" % "2.8.0",
    libraryDependencies += "org.apache.tika" % "tika-parsers-standard-package" % "2.8.0",
  )



