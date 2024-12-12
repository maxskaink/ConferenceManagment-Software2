package co.edu.unicauca.Microservicio.de.evaluacion.services.DTO;

public class BasicDate {
    private final int day;
    private final int month;
    private final int year;
    public BasicDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
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

    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }
}
