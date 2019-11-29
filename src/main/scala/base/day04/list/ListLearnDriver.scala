package base.day04.list

import scala.collection.immutable.{::, List, Nil}
import scala.collection.mutable.ListBuffer

/**
  * @description ListLearnDriver
  * @author ZerlindaLi create at 2019/4/28 18:15
  * @version 1.0.0
  */
object ListLearnDriver {

  /*def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 12, 2, 1, 1, 2, 4)
    println(list.grouped(2).toList) // List(List(1, 2), List(3, 4), List(5))
    val list2 = list.sortWith(_.compareTo(_) < 0)
    println(list2)

    val list1 = List(1)
    println(list1.tail)
    println(list1.head)

    val mainList = List(3, 2, 1)
    val with4 = 4 :: mainList // re-uses mainList, costs one :: instance
    val with42 = 42 :: mainList // also re-uses mainList, cost one :: instance
    val shorter = mainList.tail // costs nothing as it uses the same 2::1::Nil instances as mainList
    println("with4:" + with4)
    println("with42:" + with42)
    println("shorter:" + shorter)

    // Make a list via the companion object factory
    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    // Make a list element-by-element
    val when = "AM" :: "PM" :: List()

    // Pattern match
    days match {
      case firstDay :: otherDays =>
        println("The first day of the week is: " + firstDay)
        println("The other days of the week are: " + otherDays)
      case List() =>
        println("There don't seem to be any week days.")
    }

    val List(a,b) = when
    println("a:" + a)
    println("b:" + b)

    println("===============================")

    val fruit = "apples" :: ("oranges"::("paers" :: Nil))
    val nums = 1 :: (2::(3::(4::Nil)))
    val nums2 = 1 :: 2::3::4::Nil
    val diag3 = (1::(0::(0::Nil))) ::
                (0::(1::(0::Nil))) ::
                (0::(0::(1::Nil))) :: Nil
    println("fruit:"+fruit)
    println("nums:"+nums)
    println("num2:"+nums2)
    println("diag3:"+diag3)

    println(isort(list))

    println("=============== ::: ================")
    println((1::1::Nil):::(2::2::Nil))

    println(append((1::2::3::Nil),(4::5::6::Nil)))

    println(new ListBuffer[Int] ++= (4::5::6::Nil))

    testMaoHao(list)

    println(list.length)

    // list = List(1, 2, 3, 4, 5, 12, 2, 1, 1, 2, 4)
    println(list.last) // 4

    println(list.init) // List(1, 2, 3, 4, 5, 12, 2, 1, 1, 2)

    println(list.reverse) // List(4, 2, 1, 1, 2, 12, 5, 4, 3, 2, 1)

    println(list.equals(list.reverse.reverse)) // true

    println(list.eq(list.reverse.reverse)) // false

    println(list.reverse.init equals list.tail.reverse) // true

    println(myReverse(list)) // List(4, 2, 1, 1, 2, 12, 5, 4, 3, 2, 1)


/*    val list3 = Nil;
    val skuNoInWhereSql = list3.grouped(200).map{x=>
      s" or a.sku_no in ('${x.mkString("','")}')"
    }.mkString(" ").substring(3)

    println(skuNoInWhereSql)*/


    println("take: "+ (list take 3))
    println("drop: "+ (list drop 1))
    println("splitAt: "+(list splitAt(2)))

    println("list.apply(1): "+list.apply(0))
    println("list.indices: "+list.indices)
    println("list.exists(x=>x==1): "+list.exists(x=>x==122))

    val sumList = List(List(1,2,3),List(4,5,6))
    println(s"sumList.flatten.size:${sumList.flatten.size}")


    val sum2List = List((1,List(1,2,3),List(4,5,6)),(2,List(11,21,31),List(42,52,62)))
    println(s"sum2List.flatten.size:${sum2List.map(_._1)}")
    println(s"sum2List.flatten.size:${sum2List.flatMap(_._2)}")

  }*/


  def myReverse[T](xs:List[T]):List[T] = {
    xs match {
      case List() => Nil
      case x::xsrest => myReverse(xsrest):::List(x)
    }
  }

  def testMaoHao[T](xs:T)={
    xs match {
      case xs:Int => println("Int")
      case xs:List[Int] => println("List[Int]")
      case xs => println(false)
    }
  }

  def append[T](xs:List[T], ys:List[T]):List[T] = {
    xs match {
      case List() => ys
      case x::xsrest => x::append(xsrest, ys)
    }
  }

  def isort(xs:List[Int]) : List[Int] = {
/*    if(xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))*/
    /**
      * 模式匹配的方式排序
      */
    xs match {
      case List() => List()
      case x :: xsrest => insert(xs.head, isort(xs.tail))
    }
  }

  def insert(x: Int, xs:List[Int]) : List[Int] = {
/*    if(xs.isEmpty || x<=xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)*/

    xs match {
      case List() => List(x)
      case xsh :: xsrest => if(x <= xsh) x::xs
      else xsh :: insert(x, xsrest)
    }
  }

  def listforeach () = {
    val list:List[Person] = List(null)
    list.map(_.name.equals("2342"))
  }

  def filterTest() = {
    val persons = List(Person(1,None,"1223"),Person(1,None,"243"),Person(2,None,"12fd"),Person(4,None,"1a2"))
    val nums = List((1,1),(2,2),(3,2))
    val temp =  nums.map(_._1)
    val result = persons.filter(x=>temp.contains(x.age))
    println(result)
  }

  def main(args: Array[String]): Unit = {
    filterTest
  }
}

case class Person(age: Int, name: Option[String], birth: String)
