package scala.com.fly.etl.mllib

import org.apache.spark.{SparkConf, SparkContext}

object CacheTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)

    val arr = sc.parallelize(Array("abc","b","c","d","e","f")) //设定数据集
    println(arr) //打印一个RDD存储格式 ParallelCollectionRDD[0] at main at <unknown>:0
    println("----------------------")
    println(arr.cache()) //打印真正的数据结果 ParallelCollectionRDD[0] at main at <unknown>:0  运行结果一样？？？
    println("----------------------------")
    arr.foreach(println)//rdd采用迭代形式打印数据的专用方法。是一个专门用来打印未进行action操作的数据的专用方法，可以对数据进行提早计算
    /**
     * cache方法的作用是将数据内容计算并保存在计算节点的内存中，这个方法的使用是针对spark的lazy数据处理模式
      */
  }

}
