package com.example.triptix.service;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.Seat;
import com.example.triptix.model.Ticket;
import com.example.triptix.model.Trip;
import com.example.triptix.repo.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TripService tripService;
    private final SeatService seatService;

    @PostMapping
    @Transactional
    public Ticket bookTicket(Long tripId, List<Long> seatIds, String userName, String userEmail) {
        Trip trip = tripService.getTripById(tripId);
        List<Seat> selectedSeats = seatService.selectSeats(tripId, seatIds);

        Ticket ticket = Ticket.builder()
                .trip(trip)
                .seats(selectedSeats)
                .passengerName(userName)
                .userEmail(userEmail)
                .build();

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ApiException("Ticket not found"));
    }

    public void cancelTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticket.getSeats().forEach(seat -> seat.setAvailable(true));
        ticketRepository.deleteById(id);
    }
}
