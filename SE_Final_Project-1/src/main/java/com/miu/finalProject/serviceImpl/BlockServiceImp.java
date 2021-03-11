package com.miu.finalProject.serviceImpl;

import com.fasterxml.jackson.datatype.jdk8.OptionalSerializer;
import com.miu.finalProject.dao.BlockDao;
import com.miu.finalProject.domain.Block;

import com.miu.finalProject.domain.Entry;
import com.miu.finalProject.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImp implements BlockService {

    @Autowired
    BlockDao blockDao;

    @Override
    public void save(Block block) {
        blockDao.save(block);
        return;

    }

    @Override
    public void deleteById(long id) {
        blockDao.deleteById(id);
    }

    @Override
    public List<Block> findAll() {
        return blockDao.findAll();
    }

    @Override
    public Block findById(long id) {
        Optional<Block> result =blockDao.findById(id);
        Block theBlock = null;
        if(result.isPresent()){
            theBlock = result.get();
        }else {
            throw new RuntimeException("Did not find Block Id: "+ id);
        }
        return theBlock;
    }

//    @Override
//    public Block getBlockByBlockID(int blockid) {
//        return blockDao.findBlockByBlockID(blockid);
//    }
//
//    @Override
//    public Block getBlockByBlockName(String blockName) {
//        return blockDao.findBlockByBlockName(blockName);
//    }
//
//    @Override
//    public List<Block> getAllBlock() {
//        return blockDao.getAllBlock();
 //   }
}
