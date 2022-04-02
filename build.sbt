ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "retikulo-rest",
    idePackagePrefix := Some("de.retikulo"),
    libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3",
    libraryDependencies += "com.h2database" % "h2" % "1.4.200"
  )
