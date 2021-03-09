package com.miu.finalProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miu.finalProject.domain.Entry;

import java.util.List;

@Repository
public interface EntryDao extends CrudRepository<Entry,Long> {

    @Query("select s from Entry s where s.entryID= :entryID")
    public Entry findEntryByEntryID(@Param("entryID") int entryID);

    @Query("select s from Entry s where s.entryName= :entryName")
    public Entry findEntryByEntryName(@Param("entryName") String entryName);

    @Query("select s from Entry s")
    public List<Entry> getAllEntry();
}
