package scala.com.fly.etl.mllib

import scala.collection.mutable

// 随机梯度下降算法

object SGD {
  val data = mutable.HashMap[Int, Int]() // 创建数据集

  def getData(): mutable.HashMap[Int, Int] = { // 生成数据集内容
    for (i <- 1 to 50) { // 创建50个数据
      data += (i -> (12 * i)) // 写入公式 y = 2x
    }
    data // 返回数据集
  }

  var a: Double = 0 // 第一步假设a为0
  var b: Double = 0.1 // 设置步进系数

  def sgd(x: Double, y: Double) = {
    a = a-b*((a*x)-y) // 设置迭代公式
  }


  def main(args: Array[String]): Unit = {
    val dataSource = getData()
    dataSource.foreach(myMap =>{ // 开始迭代
      sgd(myMap._1,myMap._2)
    })
    println("最终结果a值为 "+a)//显示结果
  }

}

/**
 * HashMap 使用 暂时没有看懂
 *
 */
