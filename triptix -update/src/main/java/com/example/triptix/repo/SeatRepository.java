package com.example.triptix.repo;

import com.example.triptix.model.Seat;
import com.example.triptix.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByTripAndIsAvailable(Trip trip, boolean isAvailable);

}
