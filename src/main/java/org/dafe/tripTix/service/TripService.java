package com.example.triptix.service;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.Destination;
import com.example.triptix.model.Location;
import com.example.triptix.model.Trip;
import com.example.triptix.repo.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@Service
@RequiredArgsConstructor
@CrossOrigin

public class TripService {
    private final TripRepository tripRepository;

    public List<Trip> getAvailableTrips() {
        return tripRepository.findAll();
    }
    public List<Trip> findTrips(Location from, Destination to) {
        return tripRepository.findByFromDestinationAndToDestination(from, to);
    }

    public List<Trip> filterTrips(Location from, Destination to, String vehicleType) {
        return tripRepository.findByFromDestination_NameAndToDestination_NameAndVehicle_VehicleType_Type(from, to, vehicleType);
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new ApiException("Trip not found"));
    }
}
