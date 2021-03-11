package com.miu.finalProject.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String month;
    private String year;


//    private String entryName;
//    private int FPPNum;
//    private int MPPNum;
//    private String startDate;
//    private String endDate;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entry")
    private Set<Block> blockList = new HashSet<Block>();

    public Entry() {
    }

    public Entry(long id, String month, String year) {

        this.id = id;
        this.month = month;
        this.year = year;
    }
    public void addBlock(Block block){
        blockList.add(block);
        block.setEntry(this);
    }
//    public String getEntryName() {
//        return entryName;
//    }
//
//    public void setEntryName(String entryName) {
//        this.entryName = entryName;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
