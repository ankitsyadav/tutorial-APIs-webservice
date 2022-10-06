package com.tutorial.service;

import java.util.List;

import com.tutorial.payloads.TutorialDto;

public interface TutorialService {

	public TutorialDto createTutorial(TutorialDto tdto);

	public List<TutorialDto> getAllTutorial();

	public TutorialDto getTutorialById(Integer id);

	public TutorialDto updateTutorial(TutorialDto tdto, Integer id);

	public void deleteTutorial(Integer id);

	public void deleteAllTutorials();

	public List<TutorialDto> getAllPublishedTutorial();

	public List<TutorialDto> getAllTutorialByKeyword(String keyword);

}
