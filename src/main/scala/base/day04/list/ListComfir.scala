package base.day04.list

/**
  * @description ListComfir
  * @author ZerlindaLi create at 2019/5/7 10:57
  * @version 1.0.0
  */
object ListComfir {

  def main(args: Array[String]): Unit = {
    val list1 = (1,2)
    val list2 = (2,3)
    val list3  = List((1,2), (2,3))
      println(list3.find(_._1.equals(2)))
    Nil.head

  }
}
