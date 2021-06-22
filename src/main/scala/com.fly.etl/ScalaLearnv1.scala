package scala.com.fly.etl

import org.apache.spark.{SparkConf, SparkContext}

object ScalaLearnv1 {
  def main(args: Array[String]): Unit = {
    // args(0) -> 1
    // 1.设置spark配置信息
    val conf = new SparkConf().setAppName("SparkLearn").setMaster("local")

    // 2. 设置运行信息
    val sc = new SparkContext(conf)
  }

}
