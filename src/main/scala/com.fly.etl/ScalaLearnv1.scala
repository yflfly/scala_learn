package scala.com.fly.etl

import org.apache.spark.{SparkConf, SparkContext}

object ScalaLearnv1 {
  def main(args: Array[String]): Unit = {
    // args(0) -> 1
    // 1.设置spark配置信息 build a sparkconf object that contains information about your application
    val conf = new SparkConf().setAppName("SparkLearn").setMaster("local") // local : to run in local mode

    // 2. 设置运行信息 tells spark how to access a cluster
    val sc = new SparkContext(conf)

    // 3. parallelized collections
    // to create a parallelized collection holding the numbers 1 to 5
    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)
    println(distData) // 打印结果 ParallelCollectionRDD[0] at main at <unknown>:0

    // 4. external datasets
    val filepath = "/Users/a58/companyproject/scala_learn/src/main/resources/delivery/0517_delivery.txt"
    val distFile = sc.textFile(filepath)
    // distFile.collect().foreach(println) 本地文件的打印


  }


}
