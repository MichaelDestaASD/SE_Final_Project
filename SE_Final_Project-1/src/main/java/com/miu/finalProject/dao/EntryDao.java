package com.miu.finalProject.dao;

import com.miu.finalProject.domain.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryDao extends JpaRepository<Entry,Long> {
}
