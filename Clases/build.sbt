ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "Clases"
  )

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
