ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "mercator"

lazy val root = (project in file("."))
  .settings(
    name := "mercator-test",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
