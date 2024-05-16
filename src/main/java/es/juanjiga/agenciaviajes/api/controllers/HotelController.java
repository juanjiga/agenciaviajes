package es.juanjiga.agenciaviajes.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.juanjiga.agenciaviajes.infrastructure.services.HotelService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    
}
