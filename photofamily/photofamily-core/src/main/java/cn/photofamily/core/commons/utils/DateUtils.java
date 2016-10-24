package cn.photofamily.core.commons.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateUtils
{
  public static final String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss zzz";
  public static final String _DATE_FORMET_STATIC = "yyyy-MM-dd HH:mm:ss";
  public static final String _DATE_FORMET_SERIES = "yyyyMMddHHmmss";
  public static final String _DATE_FORMET = "yyyy-MM-dd";
  private static ThreadLocal<Map<String, DateFormat>> threadLocal = new ThreadLocal();
  private static final String preTimestamp = " 00:00:00";
  private static final String postTimestamp = " 23:59:59";
  
  public static String getLastDayOfMonth(String date, String datePattern)
    throws ParseException
  {
    return getLastDayOfMonth(parseToDate(date, datePattern), datePattern);
  }
  
  public static String getLastDayOfMonth(Date date, String datePattern)
  {
    return formatDate(getLastDayOfMonth(date), datePattern);
  }
  
  public static Date getLastDayOfMonth(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, 1);
    int dom = c.get(5);
    c.add(5, -dom);
    
    return c.getTime();
  }
  
  public static String getFirstDayOfMonth(String date, String datePattern)
    throws ParseException
  {
    return getFirstDayOfMonth(parseToDate(date, datePattern), datePattern);
  }
  
  public static String getFirstDayOfMonth(Date date, String datePattern)
  {
    return formatDate(getFirstDayOfMonth(date), datePattern);
  }
  
  public static Date getFirstDayOfMonth(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int dom = c.get(5);
    c.add(5, -dom + 1);
    
    return c.getTime();
  }
  
  public static Date getNextDate(Date date)
  {
    return getDate(date, 1);
  }
  
  public static Date getDate(Date date, int days)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(5, days);
    return c.getTime();
  }
  
  public static Date getDateOfMonths(Date date, int months)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, months);
    return c.getTime();
  }
  
  public static Date clearTime(Date dt)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(dt);
    c.set(10, 0);
    c.set(12, 0);
    c.set(13, 0);
    c.set(14, 0);
    return c.getTime();
  }
  
  public static boolean isInDateRange(Date curDate, Date startDate, Date endDate)
  {
    if ((startDate == null) || (curDate == null)) {
      return false;
    }
    if (curDate.compareTo(startDate) >= 0)
    {
      if (endDate == null) {
        return true;
      }
      if (curDate.compareTo(endDate) <= 0) {
        return true;
      }
    }
    return false;
  }
  
  public static Date getDate(String sDate)
  {
    int nYear = Integer.parseInt(sDate.substring(0, 4));
    int nMonth = Integer.parseInt(sDate.substring(4, 6));
    int nDay = Integer.parseInt(sDate.substring(6, 8));
    
    int nHour = 0;
    if (sDate.length() >= 10) {
      nHour = Integer.parseInt(sDate.substring(8, 10));
    }
    int nMinute = 0;
    if (sDate.length() >= 12) {
      nMinute = Integer.parseInt(sDate.substring(10, 12));
    }
    int nSecond = 0;
    if (sDate.length() >= 14) {
      nSecond = Integer.parseInt(sDate.substring(12, 14));
    }
    GregorianCalendar cldr = new GregorianCalendar();
    cldr.set(nYear, nMonth - 1, nDay, nHour, nMinute, nSecond);
    return new Date(cldr.getTime().getTime());
  }
  
  public static String formatDate(Date d, String pattern)
  {
    if (d == null) {
      return null;
    }
    SimpleDateFormat sf = new SimpleDateFormat(pattern);
    return sf.format(d);
  }
  
  public static String formatDate(Date d)
  {
    if (d == null) {
      return null;
    }
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    return sf.format(d);
  }
  
  public static int getIntDate(Date d)
  {
    return new Integer(formatDate(d, "yyyyMMdd")).intValue();
  }
  
  public static String formatDate(Timestamp d, String pattern)
  {
    if (d == null) {
      return null;
    }
    SimpleDateFormat sf = new SimpleDateFormat(pattern);
    return sf.format(d);
  }
  
  public static Date parseToDate(String sDate, String pattern)
    throws ParseException
  {
    SimpleDateFormat sf = new SimpleDateFormat(pattern);
    return sf.parse(sDate);
  }
  
  public static Date parseToDateWithyyyy_MM_dd(String sDate)
    throws ParseException
  {
    return parseToDate(sDate, "yyyy-MM-dd");
  }
  
  public static String parseToDateString(String sDate)
    throws ParseException
  {
    StringBuffer date = new StringBuffer(sDate);
    date.insert(4, '-');
    date.insert(7, '-');
    return date.toString();
  }
  
  public static String parseToDateString(int sDate)
    throws ParseException
  {
    return parseToDateString(sDate);
  }
  
  public static Timestamp parseToTimestampWithyyyy_MM_dd(String dateString)
    throws ParseException
  {
    return new Timestamp(parseToDateWithyyyy_MM_dd(dateString).getTime());
  }
  
  public static Date getCurrentDate()
  {
    return new Date();
  }
  
  public static Date getMinTime(Date dt)
  {
    Date dt1 = null;
    try
    {
      dt1 = parseToDate(formatDate(dt, "yyyyMMdd"), "yyyyMMdd");
    }
    catch (ParseException e)
    {
      System.out.println("date formate error ���" + dt + ".   " + e.getMessage());
    }
    return dt1;
  }
  
  public static Date getMaxTime(Date dt)
  {
    Date dt1 = null;
    try
    {
      dt1 = getNextDate(dt);
      dt1 = parseToDate(formatDate(dt1, "yyyyMMdd"), "yyyyMMdd");
      dt1 = new Date(dt1.getTime() - 1L);
    }
    catch (ParseException e)
    {
      System.out.println("date formate error ���" + dt + ".   " + e.getMessage());
    }
    return dt1;
  }
  
  public static int getDay(Date dt)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(dt);
    return c.get(5);
  }
  
  public static int getMonth(Date dt)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(dt);
    return c.get(2);
  }
  
  public static int getIntMonth(Date dt)
  {
    return new Integer(formatDate(dt, "yyyyMM")).intValue();
  }
  
  public static Date getDayBeforeSeconds(Date date, Long seconds)
  {
    Date newDate = (Date)date.clone();
    newDate.setTime((date.getTime() / 1000L - seconds.longValue()) * 1000L);
    return newDate;
  }
  
  public static Date getBeforeDate(Date date)
  {
    return getDate(date, -1);
  }
  
  public static int daysOfTwo(Date date1, Date date2)
  {
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal1.set(11, 0);
    cal1.set(12, 0);
    cal1.set(13, 0);
    cal1.set(14, 0);
    cal2.setTime(date2);
    cal2.set(11, 0);
    cal2.set(12, 0);
    cal2.set(13, 0);
    cal2.set(14, 0);
    
    long DAY = 86400000L;
    
    return (int)((cal2.getTime().getTime() - cal1.getTime().getTime()) / DAY);
  }
  
  public static int minuteOfTwo(Date date1, Date date2)
  {
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal1.set(13, 0);
    cal1.set(14, 0);
    cal2.setTime(date2);
    cal2.set(13, 0);
    cal2.set(14, 0);
    
    long MINUTE = 60000L;
    
    return (int)((cal2.getTime().getTime() - cal1.getTime().getTime()) / MINUTE);
  }
  
  private static DateFormat getDateFormat(String pattern)
  {
    Map<String, DateFormat> m = (Map)threadLocal.get();
    if (m == null) {
      m = new HashMap();
    }
    DateFormat df = (DateFormat)m.get(pattern);
    if (df == null)
    {
      df = new SimpleDateFormat(pattern, Locale.ENGLISH);
      m.put(pattern, df);
      threadLocal.set(m);
    }
    return df;
  }
  
  public static String formatDateStatic(Object date, String DateFormat)
    throws ParseException
  {
    return getDateFormat(DateFormat).format(date);
  }
  
  public static Date parse(String strDate, String DateFormat)
    throws ParseException
  {
    return getDateFormat(DateFormat).parse(strDate);
  }
  
  public static Date getDayStart(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
    return calendar.getTime();
  }
  
  public static int compareDate(Date date, Date otherDate, int withUnit)
  {
    Calendar dateCal = Calendar.getInstance();
    dateCal.setTime(date);
    Calendar otherDateCal = Calendar.getInstance();
    otherDateCal.setTime(otherDate);
    switch (withUnit)
    {
    case 1: 
      dateCal.clear(2);
      otherDateCal.clear(2);
    case 2: 
      dateCal.set(5, 1);
      otherDateCal.set(5, 1);
    case 5: 
      dateCal.set(11, 0);
      otherDateCal.set(11, 0);
    case 10: 
      dateCal.clear(12);
      otherDateCal.clear(12);
    case 12: 
      dateCal.clear(13);
      otherDateCal.clear(13);
    case 13: 
      dateCal.clear(14);
      otherDateCal.clear(14);
    case 14: 
      break;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      throw new IllegalArgumentException("withUnit ������������ " + withUnit + " ���������������");
    }
    return dateCal.compareTo(otherDateCal);
  }
  
  public static Date getFirstWeek()
  {
    Calendar cal = Calendar.getInstance();
    
    cal.set(7, 2);
    
    cal.set(7, 1);
    
    cal.add(7, 1);
    
    return cal.getTime();
  }
  
  public static Date parsePostDate(Date date)
  {
    String time = formatDate(date, "yyyy-MM-dd");
    try
    {
      date = parse(time + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return date;
  }
  
  public static Date parsePreDate(Date date)
  {
    String time = formatDate(date, "yyyy-MM-dd");
    try
    {
      date = parse(time + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return date;
  }
}
