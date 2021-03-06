package com.miu.finalProject.dao;

import com.miu.finalProject.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
//@Query("select f from Faculty f where f.email=:email")

   List <Faculty> findAllByEmail(String email);


}
