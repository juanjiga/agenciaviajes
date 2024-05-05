package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.math.BigDecimal;
import java.util.UUID;

import es.juanjiga.agenciaviajes.api.models.request.ReservationRequest;
import es.juanjiga.agenciaviajes.api.models.response.ReservationResponse;

public interface IReservationService extends CrudService<ReservationRequest, ReservationResponse, UUID>{
    
    BigDecimal findPrice(Long hotelId);
}
