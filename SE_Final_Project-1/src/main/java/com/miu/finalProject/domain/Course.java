package com.miu.finalProject.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Coursename;
    private String courseCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Faculty faculty;

    public Course() {
    }

    public Course(long id, String coursename,String courseCode, Date startDate, Date endDate) {
        this.id = id;
         this.Coursename = coursename;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCode = courseCode;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
