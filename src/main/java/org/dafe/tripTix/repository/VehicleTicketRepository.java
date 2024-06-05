package org.dafe.tripTix.repository;

import org.dafe.tripTix.entity.Tickets;
import org.dafe.tripTix.entity.VehicleTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleTicketRepository extends JpaRepository<VehicleTicket, Integer> {
    List<VehicleTicket> findByTicket(Tickets ticket);
    List<VehicleTicket> findAll();
}