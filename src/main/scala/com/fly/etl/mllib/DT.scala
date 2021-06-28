package scala.com.fly.etl.mllib

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object DT {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    //输入数据集
    val data = MLUtils.loadLibSVMFile(sc, "/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/DTree.txt")
    // 设定分类数量
    val numericClasses = 2
    // 设定输入格式
    val categoricalFeaturesInfo = Map[Int, Int]()
    // 设定信息增益计算方式
    val impurity = "entropy"
    // 设定树高度
    val maxDepth = 5
    // 设定分裂数据集
    val maxBins = 3
    // 建立模型
    val model = DecisionTree.trainClassifier(data,numericClasses,
      categoricalFeaturesInfo,impurity,maxDepth,maxBins
    )
    // 打印决策树信息
    println(model.topNode)
  }

}


/**
 *
 * trainClassifier(input,numClasses,categoricalFeaturesInfo,impurity,maxDepth,maxBins)
 * input:rdd[labeledpoint]输入的数据集
 *numClasses 分类的数量
 * categoricalFeaturesInfo 属性对的格式，这里只是单纯的键值对
 * impurity 计算信息增益的形式
 * maxDepth  树的高度
 * maxBins 能够分裂的数据集合数量
 */



