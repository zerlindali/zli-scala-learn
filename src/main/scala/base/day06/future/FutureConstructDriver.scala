package base.day06.future

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

/**
  * @description FutureConstructDriver
  * @author ZerlindaLi create at 2019/5/8 17:31
  * @version 1.0.0
  */
object FutureConstructDriver {

  def main(args: Array[String]): Unit = {

    // 使用successful, failed, fromTry创建Future
    println(Future.successful { Thread.sleep(1000);21 + 21 })

    println(Future.failed(new Exception("Bummer!")))

    println(Future.fromTry(Success{21+21}))

    println(Future.fromTry(Failure(new Exception("Bummer!"))))

    // 使用promise得到一个Future,这个Future由promise来控制。当promise完成时，这个future才会完成
    println("======= Promise[Int] ============")
    val pro = Promise[Int]
    val fut = pro.future
    println("pro:"+pro)
    println("fut:"+fut)

    // 通过success, failure, complete来完成promise.
    println("======= pro.success(42) ============")
    pro.success(42)
    println("pro : "+pro)
    println("fut : "+fut)


  }
}
