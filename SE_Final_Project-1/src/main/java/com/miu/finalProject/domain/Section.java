package com.miu.finalProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sectionID;
	private String sectionName;
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="section")
	//private Set<Course> courseList = new HashSet<>();
	//private Entry entry;

	public Section() {

	}

	public Section(String sectionName) {
		super();
		this.sectionName = sectionName;
	//	this.courseList = courseList;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

//	public Set<Course> getCourseList() {
//		return courseList;
//	}
//
//	public void setCourseList(Set<Course> courseList) {
//		this.courseList = courseList;
//	}

//	public Entry getEntry() {
//		return entry;
//	}
//
//	public void setEntry(Entry entry) {
//		this.entry = entry;
//	}

}
