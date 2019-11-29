package base.day06.future

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
  * @description FutureFunctionalDriver
  * @author ZerlindaLi create at 2019/5/8 16:49
  * @version 1.0.0
  */
object FutureFunctionalDriver {

  implicit val ec = ExecutionContext.global
  def main(args: Array[String]): Unit = {
    val fut = Future {
      Thread.sleep(3000);
      21 + 21
    }

    // map会等待原来的Future执行完毕，将原来的Future的结果进行操作，会返回一个新的Future
    fut.map(x=>x+1).onComplete{
      case Success(s) => println("fut success:"+s)
      case Failure(e) => println("fut failure:"+e)
    }


    val fut1 = Future {
      Thread.sleep(1000);
      21 + 21
    }

    val fut2 = Future {
      Thread.sleep(1000);
      23 + 23
    }

    val res3 = for {
      x <- fut1
      y <- fut2
    } yield x + y

    res3.map(x=>x+1).onComplete{
      case Success(s) => println("res3 success:"+s)
      case Failure(e) => println("res3 failure:"+e)
    }

    (for {
      x <- Future {
        Thread.sleep(1000);
        21 + 21
      }
      y <- Future {
        Thread.sleep(1000);
        21 + 21
      }
    } yield {x + y}).onComplete{
      case Success(s) => println("res4 success:"+s)
      case Failure(e) => println("res4 failure:"+e)
    }


    Thread.sleep(20000)
  }
}
