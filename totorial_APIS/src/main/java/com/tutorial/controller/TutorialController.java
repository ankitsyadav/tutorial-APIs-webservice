package com.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.payloads.ApiResponse;
import com.tutorial.payloads.TutorialDto;
import com.tutorial.service.TutorialService;

@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialService ts;

//	 create tutorial

	@PostMapping("/tutorials")
	public ResponseEntity<TutorialDto> addNewBook(@Valid @RequestBody TutorialDto tdto) {
		TutorialDto createdTdto = this.ts.createTutorial(tdto);
		return new ResponseEntity<>(createdTdto, HttpStatus.CREATED);
	}

//	get all tutorials

	@GetMapping("/tutorials")
	public ResponseEntity<List<TutorialDto>> getAllTutorials() {

		List<TutorialDto> tlist = this.ts.getAllTutorial();

		return new ResponseEntity<>(tlist, HttpStatus.OK);

	}

//	get tutorial by ID
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<TutorialDto> getTutorialByID(@PathVariable Integer id) {

		TutorialDto t1 = this.ts.getTutorialById(id);

		return new ResponseEntity<>(t1, HttpStatus.OK);

	}

	// update tutorial

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<TutorialDto> UpdateTutorial(@Valid @RequestBody TutorialDto tdto, @PathVariable Integer id) {

		TutorialDto t = this.ts.updateTutorial(tdto, id);

		return new ResponseEntity<>(t, HttpStatus.OK);

	}

//	delete tutorial

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<ApiResponse> deleteTutorial(@PathVariable Integer id) {

		this.ts.deleteTutorial(id);

		return new ResponseEntity<>(new ApiResponse("tutorial deleted successfully", true), HttpStatus.OK);

	}

//	delete all tutorials

	@DeleteMapping("/tutorials")
	public ResponseEntity<ApiResponse> deleteAllTutorials() {

		this.ts.deleteAllTutorials();

		return new ResponseEntity<>(new ApiResponse("all tutorials deleted successfully", true), HttpStatus.OK);

	}

}
