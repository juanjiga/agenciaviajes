package es.juanjiga.agenciaviajes.infrastructure.helpers;

import org.springframework.stereotype.Component;

import es.juanjiga.agenciaviajes.domain.repositories.ReservationRepository;
import es.juanjiga.agenciaviajes.domain.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@Component
@AllArgsConstructor
public class TourHelper {

    private final TicketRepository ticketRepository;
    private final ReservationRepository reservationRepository;

}
