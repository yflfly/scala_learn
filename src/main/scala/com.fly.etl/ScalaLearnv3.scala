package scala.com.fly.etl

import org.apache.spark.{SparkConf, SparkContext}

object ScalaLearnv3 {
  def main(args: Array[String]): Unit = {
    // 1.设置spark配置信息 build a sparkconf object that contains information about your application
    val conf = new SparkConf().setAppName("SparkLearn").setMaster("local") // local : to run in local mode

    // 2. 设置运行信息 tells spark how to access a cluster
    val sc = new SparkContext(conf)
    // 代码来源网址：https://weread.qq.com/web/reader/d6532da0718b748fd65216fk34132fc02293416a75f431d
    sc.setLogLevel("ERROR")
    val filepath = " /Users/a58/companyproject/scala_learn/src/main/resources/data/file1.txt"
    val lines = sc.textFile(filepath)
    val num = 0
//    val result = lines.filter(line=>(line.trim().length> 0) &&(line.split(",").length==4))
//      .map(_.split(",")(2))
//      .map(x => (x.toInt,"")
//        .sortByKey(false)
//        .map(x => x._1).take(5)
//        .foreach(x => {
//          num = num + 1　　　
//          println(num + "\t" + x)　　
//        }) //
  }
}
