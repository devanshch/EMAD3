package com.example.emad3;

public class CourseTable {

    String courseId;
    String name;
    String duration;

    public CourseTable(){

    }

    public CourseTable(String courseId, String name, String duration) {
        this.courseId = courseId;
        this.name = name;
        this.duration = duration;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }
}
