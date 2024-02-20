package es.juanjiga.agenciaviajes.domain.repositories;

import es.juanjiga.agenciaviajes.domain.entities.TourEntity;

import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<TourEntity, Long> {

}
