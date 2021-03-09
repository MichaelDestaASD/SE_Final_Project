package com.miu.finalProject.service;

import com.miu.finalProject.dao.EntryDao;
import com.miu.finalProject.domain.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImp implements EntryService{

    @Autowired
    EntryDao entryDao;

    @Override
    public void save(Entry entry) {
        entryDao.save(entry);
        return;
    }

    @Override
    public Entry getEntryByEntryID(int entryid) {
        return entryDao.findEntryByEntryID(entryid);
    }

    @Override
    public Entry getEntryByEntryName(String entryName) {
        return entryDao.findEntryByEntryName(entryName);
    }

    @Override
    public List<Entry> getAllEntry() {
        return entryDao.getAllEntry();
    }
}
