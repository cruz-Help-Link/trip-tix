package com.example.triptix.controller;

import com.example.triptix.model.Location;
import com.example.triptix.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/all")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable Long id) {
        return locationService.findById(id);
    }

    @PostMapping
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        locationService.deleteById(id);
    }
}

