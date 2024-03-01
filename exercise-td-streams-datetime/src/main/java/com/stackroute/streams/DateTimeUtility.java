package com.stackroute.streams;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateTimeUtility {


    public List <String>  getNextMonthWorkingDays(LocalDate localDate){
        final LocalDate nextMonth = localDate.plusMonths(1);
        final LocalDate nextTowMonth = localDate.plusMonths(2);
        Stream<LocalDate> workingDays = Stream.iterate(nextMonth,localDate1 -> localDate1.isBefore(nextTowMonth),
                localDate1 -> localDate1.plusDays(1));

        return workingDays.filter(date -> date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY)
                .map(date-> date.toString()).collect(Collectors.toList());


    }

    public List <String> getScheduledBusDepartureTimings(String startTime, Duration frequency){
        if (frequency.toDays()>=1){
            return Collections.emptyList();
        }

        final LocalTime localTime = LocalTime.parse(startTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return Stream.iterate(localTime,time->time.isBefore(LocalTime.of(23,59,00))
        && time.getHour() != 1,
                time ->time.plus(frequency))
                .map(time->time.format(formatter))
                .collect(Collectors.toList());



    }





}
