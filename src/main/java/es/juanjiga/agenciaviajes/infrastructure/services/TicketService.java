package es.juanjiga.agenciaviajes.infrastructure.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import es.juanjiga.agenciaviajes.api.models.request.TicketRequest;
import es.juanjiga.agenciaviajes.api.models.response.FlyResponse;
import es.juanjiga.agenciaviajes.api.models.response.TicketResponse;
import es.juanjiga.agenciaviajes.domain.entities.TicketEntity;
import es.juanjiga.agenciaviajes.domain.repositories.CustomerRepository;
import es.juanjiga.agenciaviajes.domain.repositories.FlyRepository;
import es.juanjiga.agenciaviajes.domain.repositories.TicketRepository;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.ITicketService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class TicketService implements ITicketService {

    private final FlyRepository flyRepository;
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;

    public TicketService(FlyRepository flyRepository, CustomerRepository customerRepository,
            TicketRepository ticketRepository) {
        this.flyRepository = flyRepository;
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketResponse create(TicketRequest request) {

        var fly = flyRepository.findById(request.getIdFly()).orElseThrow();
        var customer = customerRepository.findById(request.getIdClient()).orElseThrow();

        var ticketToPersist = TicketEntity.builder()
                .id(UUID.randomUUID())
                .fly(fly)
                .customer(customer)
                .price(fly.getPrice().add(fly.getPrice().multiply(charge_price_percentage)))
                .purchaseDate(LocalDate.now())
                .arrivalDate(LocalDateTime.now())
                .departureDate(LocalDateTime.now())
                .build();

        var TicketPersisted = this.ticketRepository.save(ticketToPersist);

        log.info("Ticket saved whith id:{}", TicketPersisted.getId());

        return this.entityToResponse(TicketPersisted);
    }

    @Override
    public TicketResponse read(UUID id) {

        var ticketFromDB = this.ticketRepository.findById(id).orElseThrow();
        return this.entityToResponse(ticketFromDB);
    }

    @Override
    public TicketResponse update(TicketRequest request, UUID id) {

        var ticketToUpdate = ticketRepository.findById(id).orElseThrow();
        var fly = flyRepository.findById(request.getIdFly()).orElseThrow();

        ticketToUpdate.setFly(fly);
        ticketToUpdate.setPrice(fly.getPrice().add(fly.getPrice().multiply(charge_price_percentage)));
        ticketToUpdate.setArrivalDate(LocalDateTime.now());
        ticketToUpdate.setDepartureDate(LocalDateTime.now());

        var ticketUpDated = this.ticketRepository.save(ticketToUpdate);

        log.info("Ticket updated with id{}",ticketUpDated.getId());

        return this.entityToResponse(ticketUpDated);
    }

    @Override
    public void delete(UUID id) {
        var ticketToDelete = ticketRepository.findById(id).orElseThrow();
        this.ticketRepository.delete(ticketToDelete);

    }

    @Override
    public BigDecimal findPrice(Long flyId) {
        var fly = this.flyRepository.findById(flyId).orElseThrow();       
        return fly.getPrice().add(fly.getPrice().multiply(charge_price_percentage));
    }



    

    private TicketResponse entityToResponse(TicketEntity entity) {
        var response = new TicketResponse();
        BeanUtils.copyProperties(entity, response);
        var flyResponse = new FlyResponse();
        BeanUtils.copyProperties(entity.getFly(), flyResponse);
        response.setFly(flyResponse);
        return response;

    }

    private static final BigDecimal charge_price_percentage = BigDecimal.valueOf(0.25);

   
}
