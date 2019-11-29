package base.day09.map

/**
  * @description MapTest
  * @author ZerlindaLi create at 2019/11/18 14:22
  * @version 1.0.0
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    val map1 = Map("key1" -> 1, "key2" -> 3, "key3" -> 5)
    val map2 = Map("key2" -> 4, "key3" -> 6, "key5" -> 10)
    val map3 = Map("key4" -> 4, "key3" -> 6)
    val mapAdd1 = map3 ++ (map1 ++ map2.map(t => t._1 -> (t._2 + map1.getOrElse(t._1, 0)))).map(t=>t._1->(t._2-map3.getOrElse(t._1,0)))
    println(mapAdd1)
  }
}
