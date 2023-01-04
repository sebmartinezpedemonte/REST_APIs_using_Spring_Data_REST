package com.bharath.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
import com.bharath.eventmanagement.entities.Participant;
import com.bharath.eventmanagement.repos.ParticipantRepository;

@RestController
@RequestMapping("/events")
public class CheckInController {

	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("/checkin/{id}")
	public ResponseEntity checkIn(@PathVariable Long id) {

		Participant participant = participantRepository.findById(id).orElse(null);
		if (participant == null) {
			throw new ResourceNotFoundException();
		}
		if (participant != null) {
			if (participant.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}

		// return ResponseEntity.ok(assembler.toFullResource(participant));
		return ResponseEntity.ok(participant.getName() + " is checked in");

	}
}

//package com.bharath.eventmanagement.controllers;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.PersistentEntityResource;
//import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bharath.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
//
//import com.bharath.eventmanagement.entities.Participant;
//import com.bharath.eventmanagement.repos.ParticipantRepository;
//
//@RestController	
//@RequestMapping("/events")
//public class CheckInController {
//
//	@Autowired
//	private ParticipantRepository participantRepository;
//	
//	@PostMapping("/checkin/{id}")
//	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
////		Participant participant = participantRepository.findById(id).orElse(null);
////		
////		if(participant != null) {
////			if(participant.getCheckedIn()) {
////				throw new AlreadyCheckedInException();
////			}
////			participant.setCheckedIn(true);
////			participantRepository.save(participant);
////		}		
//		Participant participant;
//		Optional<Participant> participantOptional = participantRepository.findById(id);
//		
//		if(participantOptional.isPresent()) {
//			participant = participantOptional.get();
//			if(participant.getCheckedIn()) {
//				throw new AlreadyCheckedInException();
//			}
//			participant.setCheckedIn(true);
//			participantRepository.save(participant);
//		}else {
//			throw new ResourceNotFoundException();
//		}
//		
//		return ResponseEntity.ok(assembler.toFullResource(participant));
//	}
//	
//}
