package com.miu.finalProject.dao;

import com.miu.finalProject.domain.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryDao extends JpaRepository<Entry,Long> {

//    @Query("select s from Entry s where s.id= :id")
//    public Entry findEntryByEntryID(@Param("entryID") int id);
//
//    @Query("select s from Entry s where s.entryName= :entryName")
//    public Entry findEntryByEntryName(@Param("entryName") String entryName);
//
//    @Query("select s from Entry s")
//    public List<Entry> getAllEntry();
}
