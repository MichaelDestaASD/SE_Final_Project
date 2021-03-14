package com.miu.finalProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
//@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sectionID;
	private String sectionName;
	@ManyToMany(mappedBy = "sectionList")
	private Set<Course> courseList = new HashSet<>();
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

	public void addCourse(Course course) {
		courseList.add(course);
		course.addSection(this);
	}
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

	@Override
	public String toString() {
		return "Section{" +
				"sectionID=" + sectionID +
				", sectionName='" + sectionName + '\'' +
				", courseList=" + courseList +
				'}';
	}
}
