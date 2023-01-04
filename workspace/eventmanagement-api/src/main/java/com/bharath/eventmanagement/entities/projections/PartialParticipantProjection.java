package com.bharath.eventmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;
import com.bharath.eventmanagement.entities.Participant;

@Projection(name = "partialParticipant", types = { Participant.class })
public interface PartialParticipantProjection {
	String getName();

	Boolean getCheckedIn();
	
	//Postman:
	//http://localhost:8080/eventmanagement-api/participants?projection=partial
}
