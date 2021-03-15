package com.miu.finalProject.service;

import java.util.List;

import com.miu.finalProject.domain.Section;

public interface SectionService {
public List<Section> findAll();
	
	public Section findById(int theId);
	
	public void save(Section section);
	
	public void deleteById(int theId);
}
