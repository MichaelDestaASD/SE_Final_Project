package com.miu.finalProject.service;

import com.miu.finalProject.domain.Course;


import java.util.List;
import java.util.Optional;

public interface CourseService {
    public void save(Course course);
    public List<Course> findAll();
    public void deleteById(long id);
    public Course findById(long id);
}
