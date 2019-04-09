package base.day01

/**
  * 学生类
  * @param grade 年级
  * @param cla 班级
  * @param name 姓名
  * @param sex 性别
  * @param mark 分数
  */
case class Student (grade: Int, cla : Int, name : String, sex : Int, mark : Map[String,Int]){
 def description = grade +"年级" + cla +"班"+name + "，性别："+sex + "。语文成绩是：" + mark("Chinese") + ", 数学成绩是：" + mark("Math") + ", 英语成绩是：" + mark("English") + "."
}

object Sex extends Enumeration {
  type Sex = Int // 声明枚举对外暴露的变量类型
  val male = 1;
  val female = 2;
}