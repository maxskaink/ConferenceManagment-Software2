/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author isabe
 */
public class BasicDate {

    private int day;
    private int month;
    private int year;


    public BasicDate(int day, int month, int year) {
        if(day > 31)
            throw new IllegalArgumentException("day > 31");
        this.day = day;
        if(month > 12)
            throw new IllegalArgumentException("month > 12");
        this.month = month;
        if(year < 1900)
            throw new IllegalArgumentException("year < 1900");
        this.year = year;
    }

    public BasicDate(){}

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
