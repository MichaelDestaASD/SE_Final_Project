package com.miu.finalProject.service;



import java.util.List;

import com.miu.finalProject.domain.Block;

public interface BlockService {

    public void save(Block block);
    public Block getBlockByBlockID(int blockid);
    public Block getBlockByBlockName(String blockName);
    public List<Block> getAllBlock();
}
