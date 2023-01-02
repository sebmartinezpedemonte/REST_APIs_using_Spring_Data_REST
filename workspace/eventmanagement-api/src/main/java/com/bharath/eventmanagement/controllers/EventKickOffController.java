package com.bharath.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.eventmanagement.entities.Event;
import com.bharath.eventmanagement.repos.EventRepository;

@RestController			//Change @RepositoryRestController to @RestController
@RequestMapping("/events")
public class EventKickOffController {

	@Autowired
	private EventRepository eventRepository;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Event event;
		Optional<Event> eventOptional = eventRepository.findById(id);
		
		if(eventOptional.isPresent()) {
			event = eventOptional.get();
		}else {
			throw new ResourceNotFoundException();
		}
		
		//Event event = eventRepository.findById(id).orElse(null);		
//		if(event==null) {
//			throw new ResourceNotFoundException();
//		}
		event.setStarted(true);
		eventRepository.save(event);
		
		return ResponseEntity.ok(event.getName() + " has started");
	}
	
	
}
