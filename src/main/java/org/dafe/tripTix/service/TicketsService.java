package org.dafe.tripTix.service;

import org.dafe.tripTix.dto.AvailableSeatsDto;
import org.dafe.tripTix.dto.TicketsDto;
import org.dafe.tripTix.entity.VehicleSeats;

import java.util.List;

public interface TicketsService {
    List<TicketsDto> getAllTickets();
    TicketsDto createTicket(TicketsDto ticketDTO);
    List<AvailableSeatsDto> getAvailableSeatsByTicketId(int ticketId);
}
