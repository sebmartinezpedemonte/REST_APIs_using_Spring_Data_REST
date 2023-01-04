package com.bharath.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bharath.eventmanagement.entities.Participant;
import com.bharath.eventmanagement.entities.projections.PartialParticipantProjection;

@RepositoryRestResource(excerptProjection = PartialParticipantProjection.class)
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> ,  CrudRepository<Participant, Long>{

	Page<Participant> findByEmail(@Param("email") String email, Pageable pageable);
	
}
