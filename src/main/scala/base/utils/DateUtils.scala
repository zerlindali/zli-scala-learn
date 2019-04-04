package base.utils

import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {

  val date1 = "MM-DD HH:mm:ss sss" // 11-29 00:00:00 025

  // String --> Date
  def strToDate(timeStr: String): Date = {
    new SimpleDateFormat(date1).parse(timeStr)
  }

  // Date --> Long
  def dateToLong(date: Date): Long = {
    date.getTime
  }

  // String --> Long
  def strToLong(timeStr: String): Long = {
    dateToLong(strToDate(timeStr))
  }
  object DateUtils{}
}
