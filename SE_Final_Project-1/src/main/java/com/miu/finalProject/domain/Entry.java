package com.miu.finalProject.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryID;


    private String entryName;
    private int FPPNum;
    private int MPPNum;
    private Date startDate;
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entry")
    private Set<Block> blockList = new HashSet<Block>();

    public Entry() {
    }

    public int getEntryID() {
        return entryID;
    }


    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public int getFPPNum() {
        return FPPNum;
    }

    public void setFPPNum(int FPPNum) {
        this.FPPNum = FPPNum;
    }

    public int getMPPNum() {
        return MPPNum;
    }

    public void setMPPNum(int MPPNum) {
        this.MPPNum = MPPNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void addBlock(Block block){
        blockList.add(block);
        block.setEntry(this);
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

}
