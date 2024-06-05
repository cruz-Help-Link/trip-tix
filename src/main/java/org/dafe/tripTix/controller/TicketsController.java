package org.dafe.tripTix.controller;

import org.dafe.tripTix.dto.AvailableSeatsDto;
import org.dafe.tripTix.dto.TicketsDto;
import org.dafe.tripTix.entity.VehicleSeats;
import org.dafe.tripTix.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {


    @Autowired
    private TicketsService ticketService;

    @GetMapping
    public List<TicketsDto > getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/create-ticket")
    public TicketsDto createTicket(@RequestBody TicketsDto  ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

    @GetMapping("/{ticketId}/available-seats")
    public List<AvailableSeatsDto> getAvailableSeats(@PathVariable int ticketId) {
        return ticketService.getAvailableSeatsByTicketId(ticketId);
    }
}
