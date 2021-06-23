package scala.com.fly.etl

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}



object ScalaLearnv2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    val filepath = "/Users/a58/companyproject/scala_learn/src/main/resources/people.json"
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val people = sqlContext.jsonFile(filepath) //jsonFile：从一个包含json文件的目录中加载，文件中的每一行是一个json对象
    people.printSchema() // 注意：一个多行的json文件经常会失败
    people.registerTempTable("people")
    val teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19")
    val anotherPeopleRDD = sc.parallelize(
      """{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}""" :: Nil)
    val anotherPeople = sqlContext.jsonRDD(anotherPeopleRDD)
  }

}
