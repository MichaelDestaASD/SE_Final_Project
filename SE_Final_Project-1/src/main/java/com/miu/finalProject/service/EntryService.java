package com.miu.finalProject.service;

import java.util.List;

import com.miu.finalProject.domain.Entry;

public interface EntryService {
    public void save(Entry entry);
    public Entry getEntryByEntryID(int entryid);
    public Entry getEntryByEntryName(String entryName);
    public List<Entry> getAllEntry();
}
