package es.juanjiga.agenciaviajes.domain.repositories;

import es.juanjiga.agenciaviajes.domain.entities.TicketEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface TicketRepository extends CrudRepository<TicketEntity, UUID> {

    Optional<TicketEntity> findByTourId(Long id);
}
