package com.example.Course.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
public class Course {
    @Id
    private String coursId;
    private String courseName;
    private String trainer;
    private int duration;

    public Course() {
    }

    public Course(String coursId, String courseName, String trainer, int duration) {
        this.coursId = coursId;
        this.courseName = courseName;
        this.trainer = trainer;
        this.duration = duration;
    }

    public String getCoursId() {
        return coursId;
    }

    public void setCoursId(String coursId) {
        this.coursId = coursId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
