name := """cms"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

libraryDependencies += "org.apache.velocity" % "velocity" % "1.7"

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"