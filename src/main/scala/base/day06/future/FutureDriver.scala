package base.day06.future

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
  * @description FutureDriver
  * @author ZerlindaLi create at 2019/5/8 15:50
  * @version 1.0.0
  */
object FutureDriver {
  implicit val ec = ExecutionContext.global
  def main(args: Array[String]): Unit = {

    // 分别定义执行了3个线程f1,f2,f3
    val f1 = Future[Unit] {
      for (i <- 1 to 10) {
        println("f1:"+i)
      }
    }

    val f2 = Future{
      for (i <- 1 to 10) {
        println("f2:"+i)
      }
    }

    val f3 = Future{
      for (i <- 1 to 10) {
        println("f3:"+i)
      }
    }

    // 线程f4等f1,f2,f3执行完毕后之后，yield代码块里面的内容为f4线程执行的代码
    val f4 = for{
      list1 <- f1
      list2 <- f2
      list3 <- f3
    }yield{
      println(list1)
      println(list2)
      println(list3)
      for (i <- 1 to 10) {
        println("f4:"+i)
      }
    }

    // 回调，成功和失败两种结果
    f4.onComplete{
      case Success(e) => println("success")
      case Failure(t) => println("Failure")
    }

    // 投影
    val f = Future {
      2 / 0
    }
    for (exc <- f.failed) println(exc)

    println()
    println("f1 之後")

    // 主线程结束后，控制台会停掉，看不到子线程打印内容，所以这里沉睡10s.
    Thread.sleep(10000)
  }

}
