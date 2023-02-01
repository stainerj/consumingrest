package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeDate {

    private String time;
    private Long milliseconds_since_epoch;
    private String date;

    public TimeDate() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getMilliseconds_since_epoch() {
        return milliseconds_since_epoch;
    }

    public void setMilliseconds_since_epoch(Long milliseconds_since_epoch) {
        this.milliseconds_since_epoch = milliseconds_since_epoch;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "time='" + time + '\'' +
                ", milliseconds_since_epoch='" + milliseconds_since_epoch + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
