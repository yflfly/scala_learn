package scala.com.fly.etl.mllib

import org.apache.spark.mllib.feature.{HashingTF, IDF}
import org.apache.spark.{SparkConf, SparkContext}

object TF_IDF {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    // 读取数据文件
    val documents = sc.textFile("/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/word.txt").map(_.split(' ').toSeq)
    // 首先创建TF计算实例
    val hashingTF = new HashingTF()
    //计算文档TF的值
    val tf = hashingTF.transform(documents).cache()
    //创建IDF实例并计算
    val idf = new IDF().fit(tf)
    // 计算TF_IDF词频
    val tf_idf = idf.transform(tf)
    //打印结果
    tf_idf.foreach(println)

  }

}
