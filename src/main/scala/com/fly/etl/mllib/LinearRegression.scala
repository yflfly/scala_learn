package scala.com.fly.etl.mllib


import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object LinearRegression {
  val conf = new SparkConf().setAppName("fly").setMaster("local")
  val sc = new SparkContext(conf)

  def main(args: Array[String]): Unit = {
    val data = sc.textFile("/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/lpsa.data")
    val parseData = data.map{line=>
      val parts = line.split(",")
      LabeledPoint(parts(0).toDouble,Vectors.dense(parts(1).split(' ').map(_.toDouble))
      )
    }.cache()
    // 建立模型
    val model = LinearRegressionWithSGD.train(parseData,100,0.1)
    val prediction = model.predict(parseData.map((_.features))) // 检验测试数据集
    //打印原测试集数据使用模型后得出的结果
    println(model.predict(Vectors.dense(0,1))) //提供新的待测数据  输出结果 1.0042991995986885
  }

}






