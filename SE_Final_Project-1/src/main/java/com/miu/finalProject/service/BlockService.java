package com.miu.finalProject.service;



import java.util.List;

import com.miu.finalProject.domain.Block;
import com.miu.finalProject.domain.Entry;

public interface BlockService {

    public void save(Block block);
    public void deleteById(long id);
    public List<Block> findAll();
    public Block findById(long id);

//    public Block getBlockByBlockID(int blockid);
//    public Block getBlockByBlockName(String blockName);
//    public List<Block> getAllBlock();
}
