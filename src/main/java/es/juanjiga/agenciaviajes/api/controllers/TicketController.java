package es.juanjiga.agenciaviajes.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.juanjiga.agenciaviajes.api.models.request.TicketRequest;
import es.juanjiga.agenciaviajes.api.models.response.TicketResponse;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.ITicketService;
import lombok.AllArgsConstructor;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "ticket")
@AllArgsConstructor
public class TicketController {

    private final ITicketService ticketService;

    //@CrossOrigin("http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<TicketResponse> post(@RequestBody TicketRequest request) {

        return ResponseEntity.ok(ticketService.create(request));

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TicketResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(ticketService.read(id));
    }
    
    

}
