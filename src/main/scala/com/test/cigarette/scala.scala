package com.test.cigarette

/**
  * @description scala
  * @author ZerlindaLi create at 2019/8/5 11:37
  * @version 1.0.0
  */
object scala {
  def main(args: Array[String]): Unit = {
    val skuCount = 1
    print(BigDecimal(skuCount))

    val list = List(1,2,3,4,5,6,7)
    list.grouped(3).foreach(
      println(_)
    )
  }
}
