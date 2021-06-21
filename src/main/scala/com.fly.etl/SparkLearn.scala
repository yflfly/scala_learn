package scala.com.fly.etl

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkLearn {

  def main(args: Array[String]): Unit = {
    // args(0) -> 1
    // 1.设置spark配置信息
    val conf = new SparkConf().setAppName("SparkLearn").setMaster("local")

    // 2. 设置运行信息
    val sc = new SparkContext(conf)

    // 3. 读取外部文件数据
    //    val rdd1:RDD[String] = sc.textFile("/Users/a58/companyproject/SparkLearn/src/main/resources/test.text")
    //    val rdd1:RDD[String] = sc.textFile("/Users/a58/companyproject/SparkLearn/src/main/resources/test.text")
    val rdd1:RDD[String] = sc.textFile("/Users/a58/companyproject/SparkLearn/src/main/resources/delivery/0517_delivery.txt")

    rdd1.collect().foreach(println) // 本地打印

    val result2:RDD[(String,Int)] = rdd1.map(x=> (x,1)).reduceByKey(_+_)//
    // .collect().foreach(println)  // 经典的单词统计程序， word_count

    result2.repartition(2)  //输出结果数据
    // .saveAsTextFile("/Users/a58/companyproject/SparkLearn/src/main/resources/output2")

    // match匹配
    val field1 = 10
    field1 match {
      case 3 => println("3")
      case 10 => println("10")
      case _ => println("other")
    }
    // map: 一次处理一行数据，返回一行数据
    // flatmap: 一次处理一行数据，返回多行数据
    val array: RDD[String] = sc.makeRDD(Array("1|2|3|4|5|6|7|8|9"))
    array.collect().foreach(println)
    array.flatMap {
      x=>
        x.split("\\|")
    }.collect().foreach(println)



  }

}
