package es.juanjiga.agenciaviajes.domain.repositories;

import es.juanjiga.agenciaviajes.domain.entities.ReservationEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ReservationRepository extends CrudRepository<ReservationEntity, UUID> {

}
