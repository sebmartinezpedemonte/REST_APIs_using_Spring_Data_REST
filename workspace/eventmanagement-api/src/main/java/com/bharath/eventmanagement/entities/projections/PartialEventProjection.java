package com.bharath.eventmanagement.entities.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.bharath.eventmanagement.entities.Event;

@Projection(name = "partial", types = { Event.class })
public interface PartialEventProjection {

	String getName();

	ZonedDateTime getStartTime();

	ZonedDateTime getEndTime();
	//Hidden data by Json can be shwon
	Instant getCreated();
	
	//Postman:
	//http://localhost:8080/eventmanagement-api/events?projection=partial
}
