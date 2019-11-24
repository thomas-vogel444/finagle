import Dependencies._

ThisBuild / scalaVersion     := "2.12.9"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "finagle",
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "19.11.0",

      scalaTest % Test
    )
  )