package com.tutorial.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.entities.Tutorial;
import com.tutorial.exceptions.ResourceNotFoundException;
import com.tutorial.payloads.TutorialDto;
import com.tutorial.repositories.TutorialRepo;
import com.tutorial.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	TutorialRepo tr;

	@Autowired
	ModelMapper mp;

	@Override
	public TutorialDto createTutorial(TutorialDto tdto) {

		Tutorial t = this.mp.map(tdto, Tutorial.class);

		Tutorial saved_tut = this.tr.save(t);
		return this.mp.map(saved_tut, TutorialDto.class);

	}

	@Override
	public List<TutorialDto> getAllTutorial() {

		List<Tutorial> list = this.tr.findAll();
		List<TutorialDto> tDtoList = new ArrayList<>();

		for (Tutorial x : list) {

			tDtoList.add(this.mp.map(x, TutorialDto.class));

		}

		return tDtoList;

	}

	@Override
	public TutorialDto getTutorialById(Integer id) {
		Tutorial t1 = this.tr.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return this.mp.map(t1, TutorialDto.class);

	}

	@Override
	public TutorialDto updateTutorial(TutorialDto tdto, Integer id) {
		Tutorial t1 = this.tr.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		t1.setTitle(tdto.getTitle());
		t1.setStatus(tdto.getStatus());
		t1.setDescription(tdto.getDescription());

		return this.mp.map(t1, TutorialDto.class);

	}

	@Override
	public void deleteTutorial(Integer id) {
		Tutorial t1 = this.tr.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		this.tr.delete(t1);
	}

	@Override
	public void deleteAllTutorials() {
		this.tr.deleteAll();

	}

	@Override
	public List<TutorialDto> getAllPublishedTutorial() {
		List<Tutorial> list = this.tr.findAll();
		List<TutorialDto> tDtoList = new ArrayList<>();

		for (Tutorial x : list) {

			tDtoList.add(this.mp.map(x, TutorialDto.class));

		}

		List<TutorialDto> plist = new ArrayList<>();
		for (TutorialDto y : tDtoList) {

			if (y.getStatus().equals("online")) {
				plist.add(y);
			}

		}
		return plist;

	}

	@Override
	public List<TutorialDto> getAllTutorialByKeyword(String keyword) {
		
		return null;
	}

}
