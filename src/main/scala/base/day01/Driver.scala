package base.day01

object Driver {

  /**
    * 创建一个年级
    * @param g 几年级
    * @param c 该年级有几个班
    * @return
    */
  def createGrade(g:Int, c:Int):Grade={
    val grade = new Grade(g, createClaList(g,c))
    grade
  }

  /**
    * 创建班级集合
    * @param c 该年级有几个班
    * @return
    */
  def createClaList (g:Int, c:Int):List[Cla] = {
    var claList = List[Cla]()
    for(a <- 1 to c){
      claList = new Cla(g,a,createStudent (g,a)) :: claList
    }
    claList
  }

  /**
    * 创建一个班级
    * @param c 几班
    * @return
    */
  def createCla(g:Int, c : Int): Cla = {
    val cla = new Cla(g, c, createStudent(g,c))
    cla
  }
  /**
    * 创建一个班级的学生
    * @return
    */
  def createStudent (g:Int, c:Int) : List[Student] = {
    var s = List[Student]()
    for(a <- 1 to 40){
      s = new Student(g, c, "李程" + a,makeScore(2)+1,Map("Chinese"->makeScore(101),"Math"->makeScore(101),"English"->makeScore(101))) :: s
    }
    s
  }

  /**
  * 生成100以内的随机数
    * @param maxScore 满分
    * @return
  */
  def makeScore (maxScore : Int) : Int={
    scala.util.Random.nextInt(maxScore)
  }

  def main(args:Array[String]){

    val grade = createGrade(3,6); // 创建3年级6个班
    // 各班成绩单
    val claList = grade.classList // 所有班级集合

    claList.foreach(cla=>{
      val ss = cla.studentList
      println("\n\n==================" + grade.gradName + "年级" + cla.cName + "班 成绩单 " + "==================")
      ss.foreach(v=>println(v.description))

      // 计算每班前5名(语文、数学、英语以及总分)
      printTopFive(ss, "Chinese")
      printTopFive(ss, "Math")
      printTopFive(ss, "English")
      printTopFive(ss, "")

      // 计算每班各科平均分
      printAverageScore(ss)

      // 各班三科各等级人数比例(优:>=90;良:>=75,<90,及格:>=60,<75;不及格:<60)
      printRankScale(ss, "Chinese")
      printRankScale(ss, "Math")
      printRankScale(ss, "English")
    })

    val totalSs = claList.flatten(_.studentList) // 将集合里面的students集合合并成一个新的集合

    /*for(c <- 0 until claList.length) {
      val cla = claList(c) // 某班
      val ss = cla.studentList // 某班学生集合
      println("\n\n==================" + grade.gradName + "年级" + cla.cName + "班 成绩单 " + "==================")
      for(s <- 0 until ss.length){
        println(ss(s).description)
      }
      // 计算每班前5名(语文、数学、英语以及总分)
      printTopFive(ss, "Chinese")
      printTopFive(ss, "Math")
      printTopFive(ss, "English")
      printTopFive(ss, "")

      // 计算每班各科平均分
      printAverageScore(ss)

      // 各班三科各等级人数比例(优:>=90;良:>=75,<90,及格:>=60,<75;不及格:<60)
      printRankScale(ss, "Chinese")
      printRankScale(ss, "Math")
      printRankScale(ss, "English")

      // 年级总分前20名
      totalSs = totalSs ::: ss
    }*/

    println("\n===================年级总分前20名==================")
    printTopTwenty(totalSs, "")

    // 男女各科状元
    println("\n===================男女各科状元==================")
    printSexSubTop(totalSs,  Sex.female, "Chinese")
    printSexSubTop(totalSs,  Sex.female, "Math")
    printSexSubTop(totalSs,  Sex.female, "English")
    printSexSubTop(totalSs,  Sex.male, "Chinese")
    printSexSubTop(totalSs,  Sex.male, "Math")
    printSexSubTop(totalSs,  Sex.male, "English")
  }



  /**
    * 求各科等级人数比例
    * @param in 班级学生集合
    * @param subject 科目
    * @return
    */
  def rankScale (in : List[Student], subject : String): (Int, Int, Int, Int) = {
    (in.count(_.mark(subject)>=90),in.count(v=>v.mark(subject)>=75&&v.mark(subject)<90),in.count(v=>v.mark(subject)>=60&&v.mark(subject)<75),in.count(_.mark(subject)<60))


    // t 为元组，v为List里面的每个值
    /*val temp = in.foldLeft((0, 0, 0, 0))((t,v) => (
      if(v.mark(subject) >= 90) t._1 + 1 else t._1,
      if(v.mark(subject) >= 75 && v.mark(subject) < 90) t._2 + 1 else t._2,
      if(v.mark(subject) >= 60 && v.mark(subject) < 75) t._3 + 1 else t._3,
      if(v.mark(subject) < 60) t._4 + 1 else t._4))
    temp*/
  }

  /**
    * 打印各科成绩等级比例
    */
  def printRankScale(in : List[Student], subject : String): Unit = {
    val temp = rankScale(in, subject)
    println(subject + "成绩等级比例(优:>=90;良:>=75,<90,及格:>=60,<75;不及格:<60)为 : " + temp._1 + ":" + temp._2 + ":" + temp._3 + ":" + temp._4)
  }

  /**
    * 求各科平均分
    */
  def averageScore (in : List[Student]): (Int, Int, Int) = {
    // t 为元组，v为List里面的每个值
    val temp = in.foldLeft((0, 0, 0))((t,v) =>
      (t._1 + v.mark.getOrElse("Chinese",0), t._2 + v.mark.getOrElse("Math",0), t._3 + v.mark.getOrElse("English",0)))
    (temp._1/in.length,temp._2/in.length, temp._3/in.length)


    /*val temp = in.foldLeft((0, 0, 0))((t,v) =>
      (t._1 + v.mark("Chinese"), t._2 + v.mark("Math"), t._3 + v.mark("English")))
    val average = (temp._1/in.length,temp._2/in.length, temp._3/in.length)
    average*/
  }

  /**
    * 打印各科平均分
    */
  def printAverageScore(in : List[Student]): Unit ={
    val temp = averageScore(in)
    println("语文平均分是："+temp._1)
    println("数学平均分是："+temp._2)
    println("英语平均分是："+temp._3)
  }

  /**
    * 各科目按成绩排名
    * @param s 学生集合
    * @param subject 科目，传入null时为求总分排名
    * @return
    */
  def getScoreSort (s : List[Student], subject : String): List[Student] = {
    val flag = subject.isEmpty
    flag match {
      case true => s.sortBy(-_.mark.values.sum)
      case _ => s.sortBy(-_.mark(subject))
    }
    /*if ( subject.isEmpty ) s.sortBy(-_.mark.values.sum)
    else
      s.sortBy(-_.mark(subject))*/
  }

  /**
    * 打印科目前5名
    * @param s
    * @param subject
    */
  def printTopFive(s : List[Student], subject : String): Unit ={
    println(subject + "前五：\n"+printSort(getScoreSort(s, subject),"", 1, 5))
  }

  /**
    * 打印总分前20名
    * @param s
    * @param subject
    */
  def printTopTwenty (s : List[Student], subject : String): Unit ={
    println(subject + "年级总分前20名：\n"+printSort(getScoreSort(s, subject),"", 1, 20))
  }


  /**
   * 遍历从第start个到底end个的元素
   */
  @annotation.tailrec
  def printSort (s : List[Student], str : String, start : Int, end : Int): String = {
    if (s == null || s.length < 1 || start > end ) str
    else  printSort(s.tail, str + s.head.description + "\n", start + 1, end)
  }

  /**
    * 各科男女状元
    * @param ss 学生集合
    * @param sex
    */
  def getSexSubjectSort(ss : List[Student], sex : Int, subject : String): List[Student] ={
    getScoreSort(ss, subject).filter(_.sex == sex)
}

  /**
    * 各科男女状元
    * @param ss
    * @param sex
    * @param subject
    */
  def printSexSubTop(ss : List[Student], sex : Int, subject : String): Unit ={
    val sexStr =
    sex match {
      case Sex.female =>  "female"
      case _ =>  "male"
    }
    println( sexStr + subject + "状元" + getSexSubjectSort(ss : List[Student], sex : Int, subject : String).head.description)
  }


}
