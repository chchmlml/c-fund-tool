package io.haicheng.cfundtool.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * DateTimeUtil
 */
public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 返回当前的日期
     * 
     * @return LocalDate
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前日期时间
     * 
     * @return LocalDateTime
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串 yyyyMMdd
     * 
     * @return String
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期时间字符串 yyyyMMddHHmmss
     * 
     * @return String
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 
     * @param dateStr dateStr
     * @param pattern pattern
     * @return LocalDate
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 
     * @param dateTimeStr dateStr
     * @param pattern     pattern
     * @return LocalDate
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期相隔天数
     * 
     * @param startDateInclusive startDateInclusive
     * @param endDateExclusive   endDateExclusive
     * @return int
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     * 
     * @param startInclusive startInclusive
     * @param endExclusive   endExclusive
     * @return long
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     * 
     * @param startInclusive startInclusive
     * @param endExclusive   endExclusive
     * @return long
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     * 
     * @param startInclusive startInclusive
     * @param endExclusive   endExclusive
     * @return long
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     * 
     * @param date date
     * @return boolean
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取本月的第一天
     * 
     * @return String
     */
    public static String getFirstDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月的最后一天
     * 
     * @return String
     */
    public static String getLastDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }

    public static final Integer ADD2 = 2;

    /**
     * 获取当前日期的后两周
     * 
     * @return String
     */
    public static String getCurDateAfterTwoWeek() {
        return getCurrentLocalDate().plus(ADD2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
    }

    public static final Integer ADD6 = 6;

    /**
     * 获取当前日期的6个月后的日期
     * 
     * @return String
     */
    public static String getCurDateAfterSixMonth() {
        return getCurrentLocalDate().plus(ADD6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
    }

    public static final Integer ADD5 = 5;

    /**
     * 获取当前日期的5年后的日期
     * 
     * @return String
     */
    public static String getCurDateAfterFiveYear() {
        return getCurrentLocalDate().plus(ADD5, ChronoUnit.YEARS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的20年后的日期
     * 
     * @return String
     */
    public static String getCurDateAfterTwentyYear() {
        return getCurrentLocalDate().plus(ADD2, ChronoUnit.DECADES).format(DATE_FORMATTER);
    }
}
