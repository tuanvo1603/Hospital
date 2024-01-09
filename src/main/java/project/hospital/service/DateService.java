package project.hospital.service;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

@Service
public class DateService {

    public Date getStartDateOfThisWeek() {
        LocalDate startOfWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return Date.valueOf(startOfWeek);
    }

    public Date getToday() {
        LocalDate today = LocalDate.now();
        return Date.valueOf(today);
    }

    public int countDaysInPeriod(Date startDate, Date endDate) {
        LocalDate localStartDate = startDate.toLocalDate();
        LocalDate localEndDate = endDate.toLocalDate();
        return (int) ChronoUnit.DAYS.between(localStartDate, localEndDate);
    }

    public boolean isDateBetweenPeriod(Date date, Date startTime, Date endTime){
        return !date.before(startTime) && !date.after(endTime);
    }
}
