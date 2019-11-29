package base.day06.future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * @description FutureFailureDriver
  * @author ZerlindaLi create at 2019/5/9 18:02
  * @version 1.0.0
  */
object FutureFailureDriver {

  def main(args: Array[String]): Unit = {
    val failure = Future{42/0}
    failure.onComplete{
      case Success(s) => println(" Success failure.value : " + failure.value)
      case Failure(e) => println(" Failure failure.value : " + failure.value)
      case _ => println("failure.failed : " + failure.failed)
    }

    val expectedFailure = failure.failed
    println("expectedFailure : " + expectedFailure)
  }
}
