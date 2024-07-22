package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.util.UUID;

import es.juanjiga.agenciaviajes.api.models.request.TourRequest;
import es.juanjiga.agenciaviajes.api.models.response.TourResponse;

public interface ITourService extends SimpleCrudService<TourRequest, TourResponse, Long>{

    void removeTicket(UUID ticketId, Long tourId);

    UUID addTicket(Long flyId, Long tourId);

    void removeReservation(UUID reservationId, Long tourId);
    
    UUID addReservation(Long reservationId, Long tourId);


}
