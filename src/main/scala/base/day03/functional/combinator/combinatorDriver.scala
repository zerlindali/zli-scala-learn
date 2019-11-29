package base.day03.functional.combinator

import scala.collection.GenTraversableOnce

/**
  * @description 高阶函数map的应用,函数组合子
  *             看看这边文章，相信你会对函数有更深的理解
  *             http://blog.csdn.net/bluishglc/article/details/45291533
  * @author ZerlindaLi create at 2019/4/18 18:50
  * @version 1.0.0
  */
object combinatorDriver {

  def main(args: Array[String]): Unit = {

    println("=============map===================")
    /**
      * map 对列表中的每个元素应用一个函数，返回应用后的元素所组成的列表
      * map方法的定义如下：
      * final override def map[B, That](f: A => B)(implicit bf: CanBuildFrom[List[A], B, That]): That
      */
    val numbers = List(1,2,3,4)

    println(numbers.map((i:Int)=> i*2)) // =>List(2, 4, 6, 8)

    // 传入一个函数（Scala编译器自动把我们的方法转换为函数）
    def timesTwo(i:Int):Int = i * 2

    def plusOne(i:Int):Int = i +1

    println(numbers.map(timesTwo)) // =>List(2, 4, 6, 8)
    println(numbers.map(plusOne)) // =>List(2, 3, 4, 5)


    println("\n=============foreach==========")
    /**
      * foreach很像map，但没有返回值。foreach仅用于有副作用[side-effects]的函数。
      * foreach方法定义如下，实现是对List做了一个while遍历：
      * @inline final override def foreach[U](f: A => U)
      */
    println(numbers.foreach((i:Int)=> i * 2)) // =>()
    println(numbers) // => List(1, 2, 3, 4)

    numbers.foreach((i:Int)=> print(i * 2 + " ")) // =>2 4 6 8


    println("\n=============filter==========")
    /**
      * filter 移除任何对传入函数计算结果为false的元素，返回一个布尔值的函数通常被称为谓词函数[或判定函数]
      * filter返回一个集合，它包含最终的元素
      * def filter(p: A => Boolean): Repr = filterImpl(p, isFlipped = false)
      *
      * def filterNot(p: A => Boolean): Repr = filterImpl(p, isFlipped = true)
      *
      * private[scala] def filterImpl(p: A => Boolean, isFlipped: Boolean): Repr = {
      * val b = newBuilder
      * for (x <- this)
      * if (p(x) != isFlipped) b += x
      *
      *     b.result
      * }
      */
    println(numbers.filter((i:Int) => i % 2 == 0)) // =>List(2, 4)

    println(numbers) // =>List(1, 2, 3, 4)

    def isEven(i:Int) : Boolean = i % 2 == 0

    println(numbers.filter(isEven)) // =>List(2, 4)


    println("\n=================zip===========")
    /**
      * zip 将两个列表的内容聚合到一个对偶列表中
      * 获取两个集合的迭代器，同时遍历，都有值时组合成一个元组，放入新的集合
      * def zip[A1 >: A, B, That](that: GenIterable[B])(implicit bf: CanBuildFrom[Repr, (A1, B), That]): That = {
      * val b = bf(repr)
      * val these = this.iterator
      * val those = that.iterator
      * while (these.hasNext && those.hasNext)
      * b += ((these.next(), those.next()))
      *     b.result()
      * }
      */
    println(List(1,2,3).zip(List("a","b","c"))) // => List((1,a), (2,b), (3,c))


    println("\n=================partition===========")
    /**
      * partition 将使用给定的谓词函数分割列表
      *
      */
    val numbers2 = List(1,2,3,4,5,6,7,8,9,10)
    println(numbers2.partition(_ % 2 == 0)) // =>(List(2, 4, 6, 8, 10),List(1, 3, 5, 7, 9))


    println("\n==============find====================")
    /**
      * find 返回集合中第一个匹配谓词函数的元素
      *
      * def find(p: A => Boolean): Option[A] = {
      * var these = this
      * while (!these.isEmpty) {
      * if (p(these.head)) return Some(these.head)
      * these = these.tail
      * }
      * None
      * }
      */
    println(numbers2.find((i:Int) => i > 5)) // => Some(6)

    println(numbers.find((i:Int) => i > 5)) // => None


    println("\n==============drop & dropWhile====================")
    /**
      * drop 将删除前i个元素, 返回一个新的集合，原集合没有变化
      *
      * override def drop(n: Int): List[A] = {
      * var these = this
      * var count = n
      * while (!these.isEmpty && count > 0) {
      * these = these.tail
      * count -= 1
      * }
      * these
      * }
      *
      * dropWhile 将删除匹配谓词函数的第一个元素。例如，如果我们在numbers列表上使用dropWhile函数来去除奇数, 1将被丢弃（但3不会被丢弃，因为他被2“保护”了）。
      * A为集合元素类型
      * @inline final override def dropWhile(p: A => Boolean): List[A] = {
      * @tailrec
      * def loop(xs: List[A]): List[A] =
      * if (xs.isEmpty || !p(xs.head)) xs
      * else loop(xs.tail)
      *
      * loop(this)
      * }
      */
    println(numbers2.drop(5)) // => List(6, 7, 8, 9, 10)
    println(numbers2) // => List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(numbers2.dropWhile(_ % 2 != 0)) // => List(2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("\n==============foldLeft====================")
    /**
      * [B]定义了一个泛型
      * A表示集合元素的类型
      * flodLeft函数将第一个参数依次与集合里面的元素从左往右依次左op操作。每次与元素操作后的值作为下一次op操作的一个参数的值
      * override /*TraversableLike*/
      * def foldLeft[B](z: B)(@deprecatedName('f) op: (B, A) => B): B = {
      * var acc = z
      * var these = this
      * while (!these.isEmpty) {
      * acc = op(acc, these.head)
      * these = these.tail
      * }
      * acc
      * }
      */
    println(numbers2.foldLeft("m")((m:String, n:Int)=>s"${m}${n}")) // => m12345678910

    println("\n==============foldRight====================")
    /**
      * 与foldRight过程相反，foldRight是从右往左进行操作，"m"作为op的第二个参数值传入
      * override def foldRight[B](z: B)(op: (A, B) => B): B =
      *     reverse.foldLeft(z)((right, left) => op(left, right))
      */
    println(numbers2.foldRight("m")((m:Int, n:String)=>s"${m}${n}")) // => 12345678910m
    println(numbers2.foldRight("m")((m:Int, n:String)=>s"${n}${m}")) // => m10987654321

    println("\n==============flatten====================")
    /**
      * flatten将嵌套结构扁平化一个层级。
      *
      * asTraversable an implicit conversion which asserts that the element type of this $coll is a `GenTraversable`.
      * 这是一个隐式参数。对于集合类型，都有一个隐式的遍历器，对于最外层集合的元素中含有非集合元素，则需要传入自定义的可遍历方法
      * def flatten[B](implicit asTraversable: A => /*<:<!!!*/ GenTraversableOnce[B]): CC[B] = {
      * val b = genericBuilder[B]
      * for (xs <- sequential)
      * b ++= asTraversable(xs).seq
      *     b.result()
      * }
      */
    println(Set(List(1, 2), Map("a"->"A", "b"->"B"),Map("a"->"A", "b"->"B")).flatten) // => Set(1, 2, (a,A), (b,B))
    println(List(List(1, 2), Map("a"->"A", "b"->"B"),Map("a"->"A", "b"->"B")).flatten) // => List(1, 2, (a,A), (b,B), (a,A), (b,B))

    println("\n==============flatMap====================")
    /**
      * flatMap是一种常用的组合子，结合映射[mapping]和扁平化[flattening]。 flatMap需要一个处理嵌套列表的函数，然后将结果串连起来。
      * 这个例子先调用map，然后调用flatten，这就是“组合子”的特征，也是这些函数的本质。
      */
    val nestedNumbers = List(List(1,2), List(3,4), Map("a"->"A", "b"->"B"))
    println(nestedNumbers.flatMap(x => x.map(_ + "0000"))) // => List(10000, 20000, 30000, 40000, (a,A)0000, (b,B)0000)


    println("==================扩展函数组合子===================")
    def ourMap(numbers2:List[Int], fn:Int=>Int):List[Int]={
      numbers2.foldRight(List[Int]()){
        (x:Int, xs:List[Int])=>
          fn(x) :: xs
      }
    }

    println(ourMap(numbers2, timesTwo(_))) // => List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
  }
}
