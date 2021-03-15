package com.miu.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.miu.finalProject.domain.Block;

import java.util.List;

@Repository
public interface BlockDao extends JpaRepository<Block,Long> {



}
