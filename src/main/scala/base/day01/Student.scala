package base.day01

/**
  * 学生类
  * @param g 年级
  * @param c 班级
  * @param name 姓名
  * @param sex 性别
  * @param mark 分数
  */
class Student (g: Int, c : Int, name : String, sex : Int, mark : Map[String,Int]){
  val grade = g;
  val cla = c;
  val Name = name;
  val SEX = sex;
  val MARK = mark;
 def description = g +"年级" + c +"班"+name + "，性别："+SEX + "。语文成绩是：" + mark("Chinese") + ", 数学成绩是：" + mark("Math") + ", 英语成绩是：" + mark("English") + "."
}

object Sex extends Enumeration {
  type Sex = Int // 声明枚举对外暴露的变量类型
  val male = 1;
  val female = 2;
}