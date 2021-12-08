package com.example.myapplication;

public class First_Type {
    private String date;
    private String name;
    private String time;
    private String topics;
    private String course;

    public First_Type(String date, String name, String time, String topics,String course){
        this.date=date;
        this.name=name;
        this.time=time;
        this.topics=topics;
        this.course=course;
    }
    public First_Type(){}

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getTopics() {
        return topics;
    }

    public String getCourse() {
        return course;
    }
}
