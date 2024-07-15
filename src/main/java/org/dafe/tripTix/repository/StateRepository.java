package org.dafe.tripTix.repository;

import org.dafe.tripTix.entity.State;
import org.dafe.tripTix.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
