package com.miu.finalProject.service;

import com.miu.finalProject.dao.EntryDao;
import com.miu.finalProject.domain.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService{

    @Autowired
    EntryDao entryDao;

    @Override
    public void save(Entry entry) {
        entryDao.save(entry);
        return;
    }

    @Override
    public void deleteById(long id) {
        entryDao.deleteById(id);
    }

    @Override
    public List<Entry> findAll() {
        return entryDao.findAll();
    }

    @Override
    public Entry findById(long id) {
        Optional<Entry> result = entryDao.findById(id);
        Entry theEntry=null;
        if(result.isPresent()){
            theEntry= result.get();
        }else{
            throw new RuntimeException("Did Not Find Entry Id: "+ id);
        }
        return theEntry;
    }
}
