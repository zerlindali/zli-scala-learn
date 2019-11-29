package base.day04.list

/**
  * @description ListDiff
  * @author ZerlindaLi create at 2019/7/3 15:29
  * @version 1.0.0
  */
object ListDiff {

  def main(args: Array[String]): Unit = {
    val orderThirdNos = List("11740502562061440279","11740502562061440279")
    val sourceOrderThirdNos = List("11740502562061440279","11740502562061440279","11740502562061440279")


    val diffOrderThirdNos = orderThirdNos.diff(sourceOrderThirdNos)
    val diffsourceOrderThirdNos = sourceOrderThirdNos.diff(orderThirdNos)
    println(diffOrderThirdNos)
    println(diffsourceOrderThirdNos)

    val orderThirdNos1 = List("11740502562061440279,1,4.50","11740502562061440279,1,5.00")
    val sourceOrderThirdNos1 = List("11740502562061440279,1,0.0","11740502562061440279,1,4.50","11740502562061440279,1,5.00")

    println(orderThirdNos1.diff(sourceOrderThirdNos1).filterNot(x => diffOrderThirdNos.contains(x.split(",").head)))


  }
}
