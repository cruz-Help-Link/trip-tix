package com.example.triptix.repo;

import com.example.triptix.model.Destination;
import com.example.triptix.model.Location;
import com.example.triptix.model.Trip;
import com.example.triptix.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByFromDestinationAndToDestination(Location from, Destination to);
    List<Trip> findByVehicle_Type(VehicleType type);

    List<Trip> findByFromDestination_NameAndToDestination_NameAndVehicle_VehicleType_Type(Location from, Destination to, String vehicleType);
}
