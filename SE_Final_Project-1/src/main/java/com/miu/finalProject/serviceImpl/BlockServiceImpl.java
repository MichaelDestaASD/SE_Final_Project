package com.miu.finalProject.serviceImpl;

import com.miu.finalProject.dao.BlockDao;
import com.miu.finalProject.domain.Block;
import com.miu.finalProject.service.BlockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockServiceInterface {

@Autowired
BlockDao blockRepository;
    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public void save(Block block) {
        blockRepository.save(block);
    }

    @Override
    public Block findById(Long blockid) {
        return blockRepository.findById(blockid).get();
    }

    @Override
    public void deleteById(Long id) {
        blockRepository.deleteById(id);
    }
}
