package org.dafe.tripTix.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.Terminal;
import org.dafe.tripTix.entity.Trip;
import org.dafe.tripTix.exception.ApiException;
import org.dafe.tripTix.repository.TripRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final HttpServletRequest request;

    @Cacheable(value = "trips", unless = "#result.isEmpty() || #root.target.isAuthenticated()")
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @CacheEvict(value = "trips", allEntries = true)
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @CacheEvict(value = "trips", allEntries = true)
    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    @Cacheable(value = "availableTrips", unless = "#result.isEmpty() || #root.target.isAuthenticated()")
    public List<Trip> getAvailableTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new ApiException("Trip not found"));
    }

    @Cacheable(value = "trips", key = "#from.id + '-' + #to.id", unless = "#result.isEmpty() || #root.target.isAuthenticated()")
    public List<Trip> findTrips(Terminal from, Terminal to) {
        return tripRepository.findByFromAndTo(from, to);
    }

    public boolean isAuthenticated() {
        return (boolean) request.getAttribute("isAuthenticated");
    }
}
