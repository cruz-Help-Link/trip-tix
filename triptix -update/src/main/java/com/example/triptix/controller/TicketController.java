package com.example.triptix.controller;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.*;
import com.example.triptix.repo.TicketRepository;
import com.example.triptix.service.SeatService;
import com.example.triptix.service.TicketService;
import com.example.triptix.service.TripService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketingService;
    @PostMapping("/book")
    public Ticket bookTicket(@RequestParam Long tripId, @RequestBody List<Long> seatIds,
                             @RequestParam String userName, @RequestParam String userEmail) {
        return ticketingService.bookTicket(tripId, seatIds, userName, userEmail);
    }
    @GetMapping
    public List<Ticket> findAll() {
        return ticketingService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return ticketingService.getTicketById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ticketingService.cancelTicket(id);
    }
}
