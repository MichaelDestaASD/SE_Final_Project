package com.miu.finalProject.service;

import com.miu.finalProject.domain.Block;

import java.util.List;

public interface BlockServiceInterface {
    List<Block> findAll();

    void save(Block block);

    Block findById(Long blockid);

    void deleteById(Long id);
}
