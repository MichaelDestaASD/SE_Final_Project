package com.miu.finalProject.service;


import com.miu.finalProject.domain.Entry;


import java.util.List;

public interface EntryService {
    public void save(Entry entry);
    public void deleteById(long id);
    public List<Entry> findAll();
    public Entry findById(long id);
//    public List<Entry> getAllEntry();
//    public Entry getEntryByEntryName(String entryName);
//    public Entry getEntryByEntryID(int entryid);
}
