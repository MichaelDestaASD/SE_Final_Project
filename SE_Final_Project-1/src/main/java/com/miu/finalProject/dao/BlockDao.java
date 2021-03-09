package com.miu.finalProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miu.finalProject.domain.Block;

import java.util.List;

@Repository
public interface BlockDao extends CrudRepository<Block,Long> {

    @Query("select s from Block s where s.blockID= :blockID")
    public Block findBlockByBlockID(@Param("blockID") int blockID);

    @Query("select s from Block s where s.blockName= :blockName")
    public Block findBlockByBlockName(@Param("blockName") String blockName);

    @Query("select s from Block s")
    public List<Block> getAllBlock();
}
