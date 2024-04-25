package es.juanjiga.agenciaviajes.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.juanjiga.agenciaviajes.api.models.request.TicketRequest;
import es.juanjiga.agenciaviajes.api.models.response.TicketResponse;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.ITicketService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path = "ticket")
@AllArgsConstructor
public class TicketController {

    private final ITicketService ticketService;

   // @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<TicketResponse> post(@RequestBody TicketRequest request) {

        return ResponseEntity.ok(ticketService.create(request));

    }

}
