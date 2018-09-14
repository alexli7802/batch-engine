package example

import akka.actor.{ActorSystem}
import org.apache.spark.sql.SparkSession
import scala.collection.JavaConversions._
object BasicSparkApp {
  
  val sys = ActorSystem("actor-bg-sys")
  
  def studySessionState(ss: SparkSession): Unit = {
    println("============ studySessionState ============")
    val sess_state = ss.sessionState
    
    println(sess_state.catalog.listDatabases())
  }
  
  def studyCatalog(ss: SparkSession): Unit = {
    println("============ studyCatalog ============")
    val catal = ss.catalog
    println(
        catal.listTables("default").collectAsList().map(t => t.name)
      )
  }
  
  def studyRuntimeConfig(ss: SparkSession): Unit = {
    println("============ studyRuntimeConfig ============")
    val rc = ss.conf
    
    println( rc.getAll.mkString("\n") )
  }
  
  def studyNewSession(ss: SparkSession): Unit = {
    println("============ studyRuntimeConfig ============")
    val ss2 = ss.newSession()
    
    println("first-session:  " + ss.conf.getAll.mkString("\n"))
    println("second-session: " + ss2.conf.getAll.mkString("\n"))
  }
  
  def main(args: Array[String]): Unit = {
    
    // first: create a spark-session
		val ss = SparkSession.builder().getOrCreate()    
    
    //studySessionState(ss)
		//studyCatalog(ss)
		//studyRuntimeConfig(ss)
		studyNewSession(ss)
		
    // terminate by user input
    println("\n\npress any key to exit ...")
  	scala.io.StdIn.readLine()
  	sys.terminate()
  }
}