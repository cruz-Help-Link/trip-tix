package com.example.triptix.controller;

import com.example.triptix.model.Seat;
import com.example.triptix.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @GetMapping("/available")
    public List<Seat> getAvailableSeats(@RequestParam Long tripId) {
        return seatService.getAvailableSeats(tripId);
    }

    @PostMapping("/select")
    public List<Seat> selectSeats(@RequestParam Long tripId, @RequestBody List<Long> seatIds) {
        return seatService.selectSeats(tripId, seatIds);
    }
}

