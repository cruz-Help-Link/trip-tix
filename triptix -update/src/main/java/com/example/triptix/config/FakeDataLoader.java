package com.example.triptix.config;

import com.example.triptix.model.*;
import com.example.triptix.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@RequiredArgsConstructor
public class FakeDataLoader implements CommandLineRunner {

    private final DestinationRepository destinationRepository;
    private final LocationRepository locationRepository;
    private final SeatRepository seatRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleRepository vehicleRepository;

    private final TripRepository tripRepository;


    @Override
    public void run(String... args) throws Exception {

        // Locations
        Location location1 = new Location(null, "Lagos");
        Location location2 = new Location(null, "Ogun");
        Location location3 = new Location(null, "Enugu");

        Destination destination1 = new Destination(null, "Abuja");
        Destination destination2 = new Destination(null, "Port-Harcourt");

        locationRepository.saveAll(Arrays.asList(location1, location2, location3));

        // Vehicle Types
        VehicleType vehicleType1 = new VehicleType(null, Collections.singleton(EType.CAR));
        VehicleType vehicleType2 = new VehicleType(null, Collections.singleton(EType.MINI_BUS));
        VehicleType vehicleType3 = new VehicleType(null, Collections.singleton(EType.REGULAR_BUS));

        vehicleTypeRepository.saveAll(Arrays.asList(vehicleType1, vehicleType2, vehicleType3));

        // Vehicles
        Vehicle vehicle1 = new Vehicle(null, "58JDKSM", vehicleType1,
                4, tripRepository.findByVehicle_Type(vehicleType1));
        Vehicle vehicle2 = new Vehicle(null, "683DKSM", vehicleType2,
                7, tripRepository.findAll());
        Vehicle vehicle3 = new Vehicle(null, "Y390KSM", vehicleType3,
                20, tripRepository.findAll());

        vehicleRepository.saveAll(Arrays.asList(vehicle1, vehicle2, vehicle3));

        // Trips
        Trip trip1 = new Trip(null, location1, destination1, vehicle1, seatRepository.findAll(), LocalDateTime.now(), LocalDateTime.now());
        Trip trip2 = new Trip(null, location2, destination2, vehicle2, seatRepository.findAll(), LocalDateTime.now(), LocalDateTime.now());
        Trip trip3 = new Trip(null, location3, destination1, vehicle3, seatRepository.findAll(), LocalDateTime.now(), LocalDateTime.now());
        Trip trip4 = new Trip(null, location3, destination2, vehicle1, seatRepository.findAll(), LocalDateTime.now(), LocalDateTime.now());
        Trip trip5 = new Trip(null, location1, destination2, vehicle2, seatRepository.findAll(), LocalDateTime.now(), LocalDateTime.now());

        tripRepository.saveAll(Arrays.asList(trip1, trip2, trip3, trip4, trip5));
        // Seats
        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            seats.add(new Seat(null, "Car Seat " + i, true, trip1));
            seats.add(new Seat(null, "Car Seat " + i, true, trip4));
        }

        for (int i = 1; i <= 7; i++) {
            seats.add(new Seat(null, "Minibus Seat " + i, true, trip2));
            seats.add(new Seat(null, "Minibus Seat " + i, true, trip5));
        }

        for (int i = 1; i <= 20; i++) {
            seats.add(new Seat(null, "Regular Bus Seat " + i, true, trip3));
        }

        seatRepository.saveAll(seats);




    }

}