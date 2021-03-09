package com.miu.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miu.finalProject.domain.Section;
@Repository
public interface SectionDao extends JpaRepository<Section, Integer> {

}
