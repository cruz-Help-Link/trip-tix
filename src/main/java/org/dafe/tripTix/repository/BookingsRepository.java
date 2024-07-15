package org.dafe.tripTix.repository;

import org.dafe.tripTix.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByReference(String reference);

    List<Booking> findAllByUserId(Long userId);

}
