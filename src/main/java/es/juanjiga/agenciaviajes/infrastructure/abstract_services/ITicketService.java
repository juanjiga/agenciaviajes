package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.math.BigDecimal;
import java.util.UUID;

import es.juanjiga.agenciaviajes.api.models.request.TicketRequest;
import es.juanjiga.agenciaviajes.api.models.response.TicketResponse;

public interface ITicketService extends CrudService<TicketRequest, TicketResponse, UUID>{
    
    BigDecimal findPrice(Long idFly);
}
