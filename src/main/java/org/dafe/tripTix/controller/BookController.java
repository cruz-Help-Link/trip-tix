package org.dafe.tripTix.controller;

import org.dafe.tripTix.bean.BookTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/TicketTrip")
public class BookController {

    @PostMapping("/searchTickets")
    public ResponseEntity<BookTicket> searchTickets(@RequestBody BookTicket ticket){

      BookTicket searchedTicket;
        searchedTicket = ticket;

        return new ResponseEntity<>(searchedTicket, HttpStatus.ACCEPTED);
    }
}
