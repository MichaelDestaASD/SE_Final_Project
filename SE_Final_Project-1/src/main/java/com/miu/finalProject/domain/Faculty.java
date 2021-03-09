package com.miu.finalProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facultyID;

	private String facultyName;
	private String email;


	@JoinColumn(nullable = false)
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Course> courseList = new HashSet<Course>();


	public void addCourse(Course course){
		courseList.add(course);
		course.setFaculty(this);

	}
}
