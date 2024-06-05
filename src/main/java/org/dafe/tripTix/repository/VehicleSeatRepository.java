package org.dafe.tripTix.repository;

import org.dafe.tripTix.entity.VehicleSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleSeatRepository extends JpaRepository<VehicleSeats, Integer> {
    List<VehicleSeats> findByTicketTicketId(int ticketId);
}
