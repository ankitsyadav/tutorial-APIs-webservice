package com.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.tutorial.entities.Tutorial;

@Controller
public interface TutorialRepo extends JpaRepository<Tutorial, Integer> {

}
