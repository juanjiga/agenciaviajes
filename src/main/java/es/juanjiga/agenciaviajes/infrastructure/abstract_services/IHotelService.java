package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.util.Set;

import es.juanjiga.agenciaviajes.api.models.response.HotelResponse;

public interface IHotelService extends CatalogServices<HotelResponse>{

    Set<HotelResponse>ratingGreaterThan(Integer rating);

    Set<HotelResponse>readByRating(Integer rating);
    
}
