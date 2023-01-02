package com.bharath.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bharath.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> ,  CrudRepository<Venue, Long>{

	Page<Venue> findByPostalCode(@Param("postalCode") String postalCode, Pageable page);
	
}
