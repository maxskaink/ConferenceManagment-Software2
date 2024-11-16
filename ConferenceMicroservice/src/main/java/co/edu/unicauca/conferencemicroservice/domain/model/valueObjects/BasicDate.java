package co.edu.unicauca.conferencemicroservice.domain.model.valueObjects;

import co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;

public class BasicDate {
    private final int day;
    private final int month;
    private final int year;

    /**
     * Main constructor of BasicDate, if some values is invalid
     * throw InvalidValue exception
     * @param day must be less than 31
     * @param month must be less than 12
     * @param year must be more than 1900
     */
    public BasicDate(int day, int month, int year) {
        if(day > 31)
            throw new InvalidValue("day must be less than than 31");
        this.day = day;
        if(month > 12)
            throw new InvalidValue("month must be less than 12");
        this.month = month;
        if(year < 1900)
            throw new InvalidValue("Year must be more than 1900");
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
