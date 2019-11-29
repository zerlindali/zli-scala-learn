package base.day07.str

import scala.math.BigDecimal.RoundingMode

/**
  * @description EqualsTest
  * @author ZerlindaLi create at 2019/6/11 15:27
  * @version 1.0.0
  */
object EqualsTest {
  def main(args: Array[String]): Unit = {
    println("  fs fd fd  ".replaceAll(" ",""));
    println("process_id,nc_message 994bdf30-6be9-4062-8e24-b1229d0ea0e9,单据  994bdf30-6be9-4062-8e24-b1229d0ea0e9  开始处理... (1)字段memo长度超过限定长度181 (2)字段memo长度超过限定长度181 单据  994bdf30-6be9-4062-8e24-b1229d0ea0e9  处理错误:单据翻译转换错误:单据校验转换失败 90664c96-2cb1-4a69-b2f6-1225922c1b5d,单据  90664c96-2cb1-4a69-b2f6-1225922c1b5d  开始处理...".replaceAll("\n"," "));
    println(BigDecimal(1200).setScale(2, RoundingMode.HALF_UP))

    println("".length)
  }
}
