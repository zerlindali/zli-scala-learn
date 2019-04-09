package base.day02

import base.utils.DateUtils
import scala.io.Source
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator



/**
  * 2.服务日志分析： 给定一个日志文件，统计每个服务的
  * 调用次数，
  * 平均时长，
  * 并统计top95、top99的平均时长 。-->排序
  *
  * 提示：
  *  2.1. 根据业务线程池的线程号来分析单次的服务调用。 线程号规则为:trans-pool-1-thread-N(N为1-2位数字)
  */
object Driver {
//  var list = List[(String,String,String)](); // 服务开始和结束语句集合 [(时间，线程名，服务名)]

  def main(args:Array[String]): Unit ={
    val list = getThreadBeginAndEnd
    val serviceInvokeCountMap = serviceCount(list) // 每个服务调用次数
    val serviceInvokeAvgTimeMap = serviceAvgTime(serviceInvokeCountMap) // 每个服务调用的平均时长
    val serviceInvokeAvgTimeSortMap = serviceInvokeAvgTimeMap.toList.sortBy(_._2)
    serviceInvokeAvgTimeSortMap.foreach {
      case (key, value) => println("服务"+key + "调用的平均时长是" + value+"ms")
    }

    println("我是平均时长第二的服务"+serviceInvokeAvgTimeSortMap.toArray.apply(1))
    println("我是平均时长第十二的服务"+serviceInvokeAvgTimeSortMap.toArray.apply(11))
  }

  /**
    * 读取线程调用的语句仿佛到集合
    */
/*  def getThreadBeginAndEnd: Unit ={
    // 读取文件
    val source = Source.fromFile(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath+"\\base\\day02\\detail-productdb-service.2017-11-29.log","UTF-8" )
    val lineIterator = source.getLines();
    for(l <- lineIterator){
      val matcher : MatchIterator = parsePattern.findAllIn(l) // 匹配之后的迭代器
      if(!matcher.isEmpty) {
        for (l <- matcher){
          val singleThread = l.split(" ").toList
          list = (time.r.findFirstIn(l).toList(0), singleThread(3) , singleThread(6)) :: list // 时间::线程名::服务名
      }
      }
    }
  }*/

  def getThreadBeginAndEnd: List[(String,String,String)] ={
    // 判断操作系统
    val systemFlag = System.getProperty("os.name").toLowerCase().startsWith("windows")
    val pathSuffix = systemFlag match {
      case true => "\\base\\day02\\detail-productdb-service.2017-11-29.log"
      case _ => "/base/day02/detail-productdb-service.2017-11-29.log"
    }

    // 正则表达式匹配文件
    val source = Source.fromFile(s"${this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath}${pathSuffix}","UTF-8").mkString
    parsePattern.r.findAllMatchIn(source).map(v=>{(v.group(1),v.group(2),s"${v.group(5)} ${v.group(6)} ${v.group(7)}")}).toList

  }

  /**
    * 统计每个服务调用次数放入到集合
    * @param in
    * @return Map[String, List[(String,String,String)]] [服务名, [(时间,线程名,服务名)]]
    */
  def serviceCount(in:List[(String,String,String)]): Map[String, List[(String,String,String)]] ={
    val map : Map[String, List[(String,String,String)]] = in.groupBy(_._3)
    println("总共调用的服务有"+map.size+"个")
    map.keys.foreach(key=>println("服务："+ key +" 调用了"+ map(key).size/2 + "次"))
    /*for(key <- map.keys){
      println("服务："+ key +" 调用了"+ map(key).size/2 + "次")
    }*/
    map
  }

  /**
    * 统计每个服务调用的平均时长
    * @param in
    * @return Map[String, Long] [服务名,平均时长]
    */
  def serviceAvgTime(in: Map[String, List[(String,String,String)]]) : Map[String, Long]={
    var map = Map[String, Long]()  // 每个服务的平均时长集合
    for(key <- in.keys){
      val service : List[(String,String,String)] = in(key) // 得到每个服务调用的开始和结束语句的集合

      var avgTime = 0L

      service.grouped(2).toList.foreach(v=>{avgTime = avgTime + Math.abs(DateUtils.strToLong(v(0)._1) - DateUtils.strToLong(v(1)._1))})

      map = map + (key -> avgTime/service.grouped(2).size)
      avgTime = 0L
    }
    map
  }

  /*def serviceAvgTime(in: Map[String, List[(String,String,String)]]) : Map[String, Long]={
    var map = Map[String, Long]()  // 每个服务的平均时长集合
    for(key <- in.keys){
      val service : List[(String,String,String)] = in(key) // 得到每个服务调用的开始和结束语句的集合
      val serviceThread : Map[String, List[(String,String,String)]] = service.groupBy(_._2)// 得到服务中每次调用的开始和结束语句
      var avgTime = 0L
      for(key <- serviceThread.keys) { // 遍历服务中每次调用，计算每次调用所需时间
        val singleThread: List[(String, String, String)] = serviceThread(key)
        singleThread.size match {
          case 1 => println(key)
          case _ =>avgTime = avgTime + Math.abs(DateUtils.strToLong(singleThread.head._1) - DateUtils.strToLong(singleThread.tail.head._1))
        }
        // 求平均时长
        //        avgTime = avgTime + Math.abs(DateUtils.strToLong(singleThread.head._1) - DateUtils.strToLong(singleThread.tail.head._1))
      }
      map = map + (key -> avgTime/serviceThread.size)
      avgTime = 0L
    }
    map
  }*/
  /**
    * 日志分析正则表达式
    */
  def parsePattern: String ={
    val time = "(\\d{2}\\-\\d{2} \\d{2}:\\d{2}:\\d{2} \\d{3})"
    val thread = "(\\S+?)"
    val level = "(INFO)"
    val byte = "(\\S+)"
    val service = "(\\S+)"
    val version = "(\\d{1}\\.\\d{1}\\.\\d{1})"
    val method = "(\\S+)"
    val other = "(.*[request body][response header].*?)"
    s"$time $thread $level $byte $service $version $method $other "
  }

}
