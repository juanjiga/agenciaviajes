package es.juanjiga.agenciaviajes.domain.repositories;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import es.juanjiga.agenciaviajes.domain.entities.HotelEntity;


public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    Set<HotelEntity> findByPriceLessThan(BigDecimal price);

    Set<HotelEntity> findByPriceBetween(BigDecimal min, BigDecimal max);

    Set<HotelEntity> findByRatingGreaterThan(Integer rating);


    
}
