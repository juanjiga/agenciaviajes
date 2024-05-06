package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.util.Set;

import es.juanjiga.agenciaviajes.api.models.response.FlyResponse;

public interface IFlyService extends CatalogServices<FlyResponse> {

    Set<FlyResponse> readByOriginDestiny(String origin, String destiny);
    
    
}
