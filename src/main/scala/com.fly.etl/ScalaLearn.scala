package scala.com.fly.etl

object ScalaLearn {
  def main(args: Array[String]): Unit = {
    // 1.输出打印
    println("my name is fly,换行")
    print("my name is fly，不换行\n")

    // 2.注释
    // 单行注释
    /* 单行注释*/
    /**
     * 多行注释
     */

    // 3.变量和函数定义
    var field1:Int = 123  //可变变量var
    val field2:String = "fly"  // 不可变变量val
    println(field1)
    println(s"field1=${field1},field2=${field2}")
    myFunction1(field1.toString)
    println(myFunction2(field1.toString))

    // 4. 集合
    val array: Array[Int] = Array(1,2,3,4,5,6,7,8,9)
    val list: List[Int] = List(1,2,3,4,5,6,7,8,9)
    val set: Set[Int] = Set(1,2,3,4,5,6,7,8,9)
    val map: Map[Int,Int] = Map(1->1,2->2,3->3,4->4,5->5,6->6,7->7,8->8,9->9)
    for(arr <- array){
      // println(arr)
    }
    for(i <- 0 until array.length){
      // println(array(i))
    }
    println(array.mkString("|"))
    // 5.常用函数使用
    array.map{  // map
      x=>
        x+10
    }.foreach(println)
    array.filter(x=> x%2==0).foreach(println)  // filter
    val result1 = array.reduce(_+_)  //任意两个元素相加 reduce
    println(result1)
    array.map(x=> (x,x)).foreach(x=> println(x._1+"|"+x._2)) // 数组转换为2元组

  }


  def myFunction1(field1: String):Unit={
    println(s"myFunction field1=${field1}")
  }
  def myFunction2(field1: String):Int={
    field1.toInt
  }

}
