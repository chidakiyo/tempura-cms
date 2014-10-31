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

libraryDependencies ++= (Seq(
	"org.apache.velocity"			%	"velocity"					%	"1.7",
	"postgresql"					%	"postgresql"				%	"9.1-901-1.jdbc4"
) ++ Seq( // scalikeJDBC
	"org.scalikejdbc"				%%	"scalikejdbc"				%	"2.1.2",
	"com.h2database"				%	"h2"						%	"1.4.181",
	"ch.qos.logback"				%	"logback-classic"			%	"1.1.2"
) ++ Seq( // flyway
	"com.github.tototoshi"			%%	"play-flyway"				%	"1.1.2"
) ++ Seq( // scala-logging
	"com.typesafe.scala-logging"	%%	"scala-logging"				%	"3.1.0",
	"org.slf4j"						%	"slf4j-api"					%	"1.7.1",
	"ch.qos.logback"				%	"logback-classic"			%	"1.0.7"
))
