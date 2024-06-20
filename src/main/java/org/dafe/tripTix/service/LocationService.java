package com.example.triptix.service;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.Location;
import com.example.triptix.repo.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> findAll() {
        var all = locationRepository.findAll();
        if (all.isEmpty()) {
            throw new ApiException("No Location");
        }
        return all;
    }

    public Location findById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ApiException("Location not found"));
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}

