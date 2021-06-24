package scala.com.fly.etl.mllib

import org.apache.spark.{SparkConf, SparkContext}

object Cartesian {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)

    val arr1 = sc.parallelize(Array(1, 2, 3, 4, 5, 6))
    val arr2 = sc.parallelize(Array(6, 5, 4, 3, 2, 1))
    val result = arr1.cartesian(arr2) //进行笛卡尔计算
    result.foreach(println)

    /** 打印出结果
     *  (1,6)
        (1,5)
        (1,4)
        (1,3)
        (1,2)
        (1,1)
        (2,6)
        (2,5)
        (2,4)
        (2,3)
        (2,2)
        (2,1)
        (3,6)
        (3,5)
        (3,4)
        (3,3)
        (3,2)
        (3,1)
        (4,6)
        (4,5)
        (4,4)
        (4,3)
        (4,2)
        (4,1)
        (5,6)
        (5,5)
        (5,4)
        (5,3)
        (5,2)
        (5,1)
        (6,6)
        (6,5)
        (6,4)
        (6,3)
        (6,2)
        (6,1)
     */

  }
}
