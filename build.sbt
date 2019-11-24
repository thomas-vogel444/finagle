import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "finagle",
    libraryDependencies ++= Seq(
      scalaTest % Test
    )
  )