package scala.com.fly.etl.mllib

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object LogisticRegression2 {
  val conf = new SparkConf().setAppName("fly").setMaster("local")
  val sc = new SparkContext(conf)

  def main(args: Array[String]): Unit = {
    // 获取数据集
    val data = MLUtils.loadLibSVMFile(sc,"/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/wa.txt")
    val splits = data.randomSplit(Array(0.7,0.3),seed = 11L)//对数据集切分
    //分割训练集
    val parseData = splits(0)
    // 分割测试集
    val parseTest = splits(1)
    //训练模型
    val model = LogisticRegressionWithSGD.train(parseData,50)
    // 计算测试值 存储测试和预测值
    val predicttionAndLabels = parseTest.map{
      case LabeledPoint(label, features)=>
        val prediction =model.predict(features)
        (prediction,label)
    }
    // 创建验证类
    val metrics = new MulticlassMetrics(predicttionAndLabels)
    // 计算验证值
    val precision = metrics.precision
    // 打印验证值
    println("precison "+ precision)
    // 计算患者可能性
    val patient = Vectors.dense(Array(70,3,180.0,4,3))
    if (patient==1){
      println("患者的肾癌有几率转移")
    }
    else{
      println("患者的肾癌没有几率转移")
    }

  }

}
