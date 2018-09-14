import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "batch-engine",
    libraryDependencies ++= (scalaTest % Test) +: (sparkDeps ++ akkaDeps) 
  ).
  settings(
    assemblyJarName in assembly := "cellos-na-batchengine.jar",
    test in assembly := {}
  )
 
