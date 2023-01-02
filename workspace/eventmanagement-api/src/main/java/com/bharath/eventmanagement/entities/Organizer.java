package com.bharath.eventmanagement.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
@Entity
public class Organizer extends AbstractEntity {

	private String name;
	
	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getResourceId() {
		return super.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(super.getId(), ((Organizer)obj).getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.getId());
	}
}
