package scala.com.fly.etl.mllib

import org.apache.spark.mllib.feature.Word2Vec
import org.apache.spark.{SparkConf, SparkContext}

object word2Vec {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("fly").setMaster("local")
    val sc = new SparkContext(conf)
    // 读取数据文件
    val documents = sc.textFile("/Users/a58/companyproject/scala_learn/src/main/resources/mllibdata/word.txt").map(_.split(' ').toSeq)
    //创建词向量实例
    val word2vec = new Word2Vec()
    //训练模型
    val model = word2vec.fit(documents)
    // 打印向量模型
    println(model.getVectors)
    //寻找spark的相似词
    val synonyms = model.findSynonyms("spark",2) //spark查找目标 2为查找数量
    //打印找到的内容
    for(synonym<-synonyms){
      println(synonym)
    }

  }

}








