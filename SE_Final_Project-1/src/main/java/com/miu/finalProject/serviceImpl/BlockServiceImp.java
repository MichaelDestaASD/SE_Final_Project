package com.miu.finalProject.serviceImpl;

import com.miu.finalProject.dao.BlockDao;
import com.miu.finalProject.domain.Block;

import com.miu.finalProject.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Block getBlockByBlockID(int blockid) {
        return blockDao.findBlockByBlockID(blockid);
    }

    @Override
    public Block getBlockByBlockName(String blockName) {
        return blockDao.findBlockByBlockName(blockName);
    }

    @Override
    public List<Block> getAllBlock() {
        return blockDao.getAllBlock();
    }
}
