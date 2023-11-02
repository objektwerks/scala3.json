enablePlugins(JmhPlugin)

name := "scala3.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1"
libraryDependencies ++= {
  val circeVersion = "0.14.5"
  val jsoniterVersion = "2.24.4"
  val upickleVersion = "3.1.3"
  val zioJsonVersion = "0.6.2"
  val sprayJsonVersion = "1.3.6"
  Seq(
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "dev.zio" %% "zio-json" % zioJsonVersion,
    "io.spray" %% "spray-json" % sprayJsonVersion,
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
  )
}
parallelExecution := false
scalacOptions ++= Seq(
  "-Wunused:all"
)
