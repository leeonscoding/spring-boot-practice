package com.leeonscoding.springangular;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @GetMapping
    public ResponseEntity<Ticket> getTicket() {
        String unique = UUID.randomUUID().toString();

        return new ResponseEntity<>(new Ticket(unique), HttpStatus.OK);
    }
}
