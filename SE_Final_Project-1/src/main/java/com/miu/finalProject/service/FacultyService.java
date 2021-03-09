package com.miu.finalProject.service;

import com.miu.finalProject.domain.Faculty;


import java.util.List;
import java.util.Optional;

public interface FacultyService {
   void deleteById(Long id);


    void save(Faculty faculty);
   List<Faculty> getByEmail(String email);

    List<Faculty> findAll();

    Optional<Faculty> findById(Long id);
}
