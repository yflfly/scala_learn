package scala.com.fly.etl.mllib

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    // WordCount是mapreduce入门必看的例子
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    // 创建环境变量
    val sc =new SparkContext(conf)
    val filepath = "/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/wc.txt"
    // 创建环境变量实例
    val data = sc.textFile(filepath) //文件的读取
    // 读取文件 word 计数
    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
    /*
    * flatMap()是scala中提取相关数据按行处理的一个方法
    * _.split(" ")中，下划线是一个占位符，代表传送进来的任意一个数据，对其按照" "分割
    * map((_,1))是对每一个字符开始计数，在这个过程中，并不涉及合并和计算，只是单纯地将每个数据行中单词加1
    * reduceByKey()方法是对传递进来的数据按key值相加，最终形成WordCount计算结果
    * collect()是对程序的启动，因为spark编程的优化，很多方法子啊计算过程中属于lazy模式，因此需要一个显性启动支持
    * foreach(println)是打印的一个调用方法，打印出数据内容
    * */
  }

}
