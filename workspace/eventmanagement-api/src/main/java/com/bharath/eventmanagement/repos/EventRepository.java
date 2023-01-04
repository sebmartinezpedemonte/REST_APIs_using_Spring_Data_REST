package com.bharath.eventmanagement.repos;

import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bharath.eventmanagement.entities.Event;
import com.bharath.eventmanagement.entities.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class) //it only applies to Collections, not to single resources
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, CrudRepository<Event, Long> {

	Page<Event> findByName(@Param("name") String name, Pageable pageable);

	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
	
	
}
