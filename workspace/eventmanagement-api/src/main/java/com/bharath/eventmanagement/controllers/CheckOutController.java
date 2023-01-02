package com.bharath.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.eventmanagement.entities.Participant;
import com.bharath.eventmanagement.repos.ParticipantRepository;
import com.bharath.eventmanagement.controllers.exceptions.NotCheckedInException;

@RestController
@RequestMapping("/events")
public class CheckOutController {
	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkout(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {
		Participant participant = participantRepository.findById(id).orElse(null);
		if (participant != null) {
			if (!participant.getCheckedIn()) {
				throw new NotCheckedInException();
			}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		}
		return ResponseEntity.ok(assembler.toFullResource(participant));
	}
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.PersistentEntityResource;
//import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
////import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bharath.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
//import com.bharath.eventmanagement.controllers.exceptions.NotCheckInException;
//import com.bharath.eventmanagement.entities.Participant;
//import com.bharath.eventmanagement.repos.ParticipantRepository;
//
//@RestController
//@RequestMapping("/events")
//public class CheckOutController {
//
//	@Autowired
//	private ParticipantRepository participantRepository;
//
//	@PostMapping("/checkout/{id}")
//	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id,PersistentEntityResourceAssembler assembler) {
//
//		Participant participant = participantRepository.findById(id).orElse(null);
//
//		if (participant != null) {
//			if (!participant.getCheckedIn()) {
//				throw new NotCheckInException();
//			}
//			participant.setCheckedIn(false);
//			participantRepository.save(participant);
//		}
//
//		return ResponseEntity.ok(assembler.toFullResource(participant));
//
//	}
//}


