package base.day05.caseobject

/**
  * @description CaseObjDriver
  * @author ZerlindaLi create at 2019/4/29 20:32
  * @version 1.0.0
  */
object CaseClassDriver {
  def main(args: Array[String]): Unit = {
    val p = Person(13,"李程")
    val p2 = p.copy()
    val p22 = Person(13,"李程")
    val p3 = p.copy(age=14)
    println(p.toString + p2.toString + p3.toString)
    println(p.hashCode)
    println("p.equals(p)："+p.equals(p))
    println("p.equals(p22)："+p.equals(p22))
    println("p.equals(p2)："+p.equals(p2))
    println("p2.equals(p3)："+p2.equals(p3))
    val p$ = Person.unapply(p)
    println(p$.toString)
  }
}

/**
  * case class 编译后会生成两个class文件Person.class和Person$.class 默认为Immutable
  * Person$.class是伴生对象，实现了apply方法和unapply方法
  * apply方法返回一个实例对象
  * unapply方法将对象转为元组
  * 重写了toString,equals,hashCode方法
  */
case class Person(age: Int, name: String)


