package base.day06.future

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
  * @description FutureFilteringDirver
  * @author ZerlindaLi create at 2019/5/8 18:03
  * @version 1.0.0
  */
object FutureFilteringDirver {

  implicit val ec = ExecutionContext.global
  def main(args: Array[String]): Unit = {
    val fut = Future{42}

    // filter
    println("fut.filter(res => res > 0).value : "+fut.filter(res => res > 0).value)
    println("fut.filter(res => res < 0).value : " + fut.filter(res => res < 0).value)

    // withFilter , forexpression filters
    val valid = for(res <- fut if res > 0) yield res
    valid.onComplete{
      case Success(s) => println("valid success: "+s)
      case Failure(e) => println("valid failure: "+e)
    }

    val valid2 = for(res <- fut if res < 0) yield res
    valid2.onComplete{
      case Success(s) => println("valid2 success: "+s)
      case Failure(e) => println("valid2 failure: "+e)
    }

    // Future's collect
    val valid3 = fut collect {
      case res if res > 0 => res + 46
      case res if res < 0 => res - 46
    }
    valid3.onComplete{
      case Success(s) => println(" collect valid3 success: "+s)
      case Failure(e) => println(" collect valid3 failure: "+e)
    }

  }
}
