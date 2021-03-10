package com.miu.finalProject.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @ManyToMany
    @JoinTable(name = "Course_Faculty",
            joinColumns = { @JoinColumn(name = "Course_id") },
            inverseJoinColumns = { @JoinColumn(name = "Faculty_id") }
    )

    private List<Faculty> facultyList = new ArrayList<>();

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

    public void addFaculty(Faculty faculty){
        facultyList.add(faculty);
        faculty.addCourse(this);
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Coursename='" + Coursename + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
//                ", faculty=" + faculty +
                '}';
    }

//    public void setFaculty(Faculty faculty) {
//        this.faculty = faculty;
//    }
//    public Faculty getFaculty(){
//        return this.faculty;
//    }
}
