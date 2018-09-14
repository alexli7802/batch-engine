import sbt._

object Dependencies {

  val sparkVer = "2.2.1"
  val akkaVer = "2.5.16"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val configDep = "come.typesafe" % "config" % "1.3.1"

  lazy val sparkDeps = Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided",
    "org.apache.spark" %% "spark-sql" % sparkVer % "provided",
    "org.apache.spark" %% "spark-hive" % sparkVer % "provided",
    "org.apache.spark" %% "spark-launcher" % sparkVer % "provided"
  )

  lazy val akkaDeps = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVer,
    "com.typesafe.akka" %% "akka-remote" % akkaVer,
    "com.typesafe.akka" %% "akka-testkit" % akkaVer
  )  
}


