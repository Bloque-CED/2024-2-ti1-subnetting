val scala3Version = "3.5.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "tareaIntegradora1",
    version := "0.1",
    scalaVersion := "3.5.0",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.16" % "test",
      "org.scalameta" %% "munit" % "0.7.29" % "test"
    )
  )