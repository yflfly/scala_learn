package scala.com.fly.etl.mllib

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

// 一元逻辑回归
object LogisticRegression {
  val conf = new SparkConf().setAppName("fly").setMaster("local")
  val sc = new SparkContext(conf)

  def main(args: Array[String]): Unit = {
    val path = "/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/u.txt"
    val data = sc.textFile(path)
    val parseData = data.map{line=>
      val parts = line.split(",")
      LabeledPoint(parts(0).toDouble,
        Vectors.dense(parts(1).split(" ").map(_.toDouble)))
    }.cache()
    // 建立模型
    val model = LogisticRegressionWithSGD.train(parseData,50)
    val target = Vectors.dense(-1) // 创建测试值
    val result = model.predict(target) //根据模型计算结果
    println(result) // 打印结果 1.0

  }

}








