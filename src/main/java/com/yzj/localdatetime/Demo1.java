package com.yzj.localdatetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-20 15:45
 */
public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.now();
        demo1.cycleDate();
        demo1.plusHours();
        demo1.nextWeek();
        demo1.minusDate();
        demo1.clock();
        demo1.isBeforeOrIsAfter();
        demo1.getZoneTime();
        demo1.checkCardExpiry();
        demo1.isLeapYear();
        demo1.calcDateDays();
        demo1.ZoneOffset();
        demo1.getTimestamp();
        demo1.formatDate();
    }

    public void now() {
        System.out.println("LocalDate.now() => " + LocalDate.now());
        System.out.println("LocalTime.now() => " + LocalTime.now());
        System.out.println("LocalDateTime.now() => " + LocalDateTime.now());
    }

    //处理周期性的日期
    public void cycleDate() {
        System.out.println("cycleDate");
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2018, 1, 21);

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }

    //增加小时
    public void plusHours() {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // 增加两小时
        System.out.println("Time after 2 hours : " +  newTime);
    }

    //如何计算一周后的日期
    public void nextWeek() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);    //使用变量赋值
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }

    //计算一年前或一年后的日期
    public void minusDate() {
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }

    public void clock() {
        // 根据系统时间返回当前时间并设置为UTC。
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);
        long millis = clock.millis();
        System.out.println("millis = " + millis);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("defaultClock : " + defaultClock);
        long defaultMillis = defaultClock.millis();
        System.out.println("defaultMillis = " + defaultMillis);
    }

    //如何用Java判断日期是早于还是晚于另一个日期
    public void isBeforeOrIsAfter() {
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = LocalDate.of(2018, 1, 29);
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }

        //减去一天
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);

        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is day before today");
        }
    }

    //获取特定时区下面的时间
    public void getZoneTime() {
        //设置时区
        ZoneId america = ZoneId.of("America/New_York");

        LocalDateTime LocalDateAndTime = LocalDateTime.now();

        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(LocalDateAndTime, america);
        System.out.println("现在的日期和时间在特定的时区 : " + dateAndTimeInNewYork);
    }

    //使用 YearMonth类处理特定的日期
    public void checkCardExpiry(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    //检查闰年
    public void isLeapYear(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    //计算两个日期之间的天数和月数
    public void calcDateDays(){
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, Month.MAY, 14);

        Period periodToNextJavaRelease = Period.between(today, java8Release);

        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
        System.out.println("years = " + periodToNextJavaRelease.getYears());
    }

    public void ZoneOffset(){
        LocalDateTime datetime = LocalDateTime.of(2018, Month.FEBRUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    public void getTimestamp(){
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    // 使用预定义的格式化工具去解析或格式化日期
    public void formatDate(){
        String dayAfterTomorrow = "20180210";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTomorrow, formatted);
    }

}
