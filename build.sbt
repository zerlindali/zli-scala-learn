import sbt.Keys.scalaVersion

name := "zli-scala-learn"

lazy val learn = (project in file("."))
  .settings(
    version := "0.1",

    scalaVersion := "2.12.8",

    libraryDependencies ++= Seq(
      "org.jxls" % "slf4j-log4j12 % 1.0.14",
      "org.jxls" % "commons-logging % 1.0.14"
    )
  )

javaOptions ++= Seq("-encoding", "UTF-8")