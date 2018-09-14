package example

import org.apache.spark.sql.{SparkSession,DataFrame}
import org.apache.spark.sql.types._

trait DataFrameLoader extends (SparkSession=>DataFrame) {
  def apply(datafile: String): SparkSession=>DataFrame
}

object GTPCLoader extends DataFrameLoader {
  def apply(datafile: String): SparkSession=>DataFrame = { ss => 
    ss.emptyDataFrame
  }
  
}