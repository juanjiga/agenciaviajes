package es.juanjiga.agenciaviajes.infrastructure.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import es.juanjiga.agenciaviajes.api.models.request.TourRequest;
import es.juanjiga.agenciaviajes.api.models.response.TourResponse;
import es.juanjiga.agenciaviajes.domain.repositories.CustomerRepository;
import es.juanjiga.agenciaviajes.domain.repositories.FlyRepository;
import es.juanjiga.agenciaviajes.domain.repositories.HotelRepository;
import es.juanjiga.agenciaviajes.domain.repositories.TourRepository;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.ITourService;
import es.juanjiga.agenciaviajes.infrastructure.helpers.TourHelper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class TourService implements ITourService {

    private final TourRepository tourRepository;
    private final FlyRepository flyRepository;
    private final HotelRepository hotelRepository;
    private final CustomerRepository customerRepository;
    private final TourHelper tourHelper;
    
    @Override
    public TourResponse create(TourRequest request) {
        
        return null;
    }

    @Override
    public TourResponse read(Long id) {
        
        return null;
    }

    @Override
    public void delete(Long id) {
        
        
    }

    @Override
    public void removeTicket(UUID ticketId, Long tourId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTicket'");
    }

    @Override
    public UUID addTicket(Long flyId, Long tourId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTicket'");
    }

    @Override
    public void removeReservation(UUID reservationId, Long tourId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeReservation'");
    }

    @Override
    public UUID addReservation(Long reservationId, Long tourId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addReservation'");
    }

   

}
