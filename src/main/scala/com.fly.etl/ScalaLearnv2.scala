package scala.com.fly.etl

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}



object ScalaLearnv2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    val filepath = "/Users/a58/companyproject/scala_learn/src/main/resources/people.json"
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val people = sqlContext.jsonFile(filepath)
    people.printSchema()
    people.registerTempTable("people")
//    val teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19")
//    val anotherPeopleRDD = sc.parallelize(
//      """{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}""" :: Nil)
//    val anotherPeople = sqlContext.jsonRDD(anotherPeopleRDD)
  }

}
