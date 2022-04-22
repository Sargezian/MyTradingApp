package com.example.mytradingapp.Shared.Transferobjects;

import java.time.LocalDate;
import java.util.Date;

public class Historical {

    private Date date;

    private double close;


    public Date getDate() { return date; }
    public void setDate(Date value) { this.date = value; }


    public double getClose() { return close; }
    public void setClose(double value) { this.close = value; }

    @Override
    public String toString() {
        return "Historical{" +
                "date=" + date +
                ", close=" + close +
                '}';
    }
}
