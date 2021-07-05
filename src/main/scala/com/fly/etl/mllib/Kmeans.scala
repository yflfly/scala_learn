package scala.com.fly.etl.mllib

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object Kmeans {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    //输入数据集
    val data = MLUtils.loadLibSVMFile(sc, "/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/Kmeans.txt")
    //数据处理
//    val parsedData = data.map(s => Vectors.dense(
//      s.split(' ').map(_.toDouble))).cache()
//    //最大分类数
//    val numCluster = 2
//    //迭代次数
//    val numIterations = 20
//    // 训练模型
//    val model = KMeans.train(parsedData,numCluster,numIterations)
//    // 打印中心点坐标
//    model.clusterCenters.foreach(println）
  }
}
