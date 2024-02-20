package es.juanjiga.agenciaviajes.domain.repositories;

import es.juanjiga.agenciaviajes.domain.entities.CustomerEntity;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
}
