package com.miu.finalProject.serviceImpl;

import com.miu.finalProject.dao.FacultyRepository;
import com.miu.finalProject.domain.Faculty;
import com.miu.finalProject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceimpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public void save(Faculty faculty) {
        facultyRepository.save(faculty);

    }

    @Override
    public List<Faculty> getByEmail(String email) {
        return facultyRepository.findAllByEmail(email);
    }



    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> findById(Long id) {
        return facultyRepository.findById(id);
    }
}
