package scala.com.fly.etl

import org.apache.spark.{SparkConf, SparkContext}

object ScalaLearnHive {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)

//    val sqlContext = new org.apache.spark.sql.hive.HiveContext(sc)
//
//    sqlContext.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)")
//    sqlContext.sql("LOAD DATA LOCAL INPATH 'examples/src/main/resources/kv1.txt' INTO TABLE src")
//
//    // Queries are expressed in HiveQL
//    sqlContext.sql("FROM src SELECT key, value").collect().foreach(println)
  }

}
