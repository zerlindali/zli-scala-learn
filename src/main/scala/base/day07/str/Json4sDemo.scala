package base.day07.str


/**
  * @description Json4sDemo
  * @author ZerlindaLi create at 2019/10/12 9:44
  * @version 1.0.0
  */
object Json4sDemo {

  def main(args: Array[String]): Unit = {
    println("2019-09".substring(0,4))
    println("2019-09".substring(5,7))
    val test = "fsd"
    println(s"${test}\\${test}")
  }
  case class User(id: Int, name: String, age: Int)
}
