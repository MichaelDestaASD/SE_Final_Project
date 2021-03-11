package com.miu.finalProject.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blockID;

    private String blockName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int FPPNum;
    private int MPPNum;
    private String entryName;

    @JoinColumn(name ="entryid",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Entry entry;

    public Block() {
    }

    public Entry getEntry(){
        return entry;
    }
        public void setEntry(Entry entry){
        this.entry = entry;
    }

    public long getBlockID() {
        return blockID;
    }

    public void setBlockID(long blockID) {
        this.blockID = blockID;
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

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }



    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

	@Override
	public String toString() {
		return "Block [blockID=" + blockID + ", blockName=" + blockName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", FPPNum=" + FPPNum + ", MPPNum=" + MPPNum + ", entryName=" + entryName + "]";
	}

}
