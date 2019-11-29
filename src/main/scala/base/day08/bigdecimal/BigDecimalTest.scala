package base.day08.bigdecimal

/**
  * @description BigDecimalTest
  * @author ZerlindaLi create at 2019/10/15 15:43
  * @version 1.0.0
  */
object BigDecimalTest {

  def main(args: Array[String]): Unit = {
    val amount = BigDecimal(12.125).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString()
    println(amount)
  }
}
