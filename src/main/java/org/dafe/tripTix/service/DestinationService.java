package com.example.triptix.service;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.Destination;
import com.example.triptix.repo.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {
    private final DestinationRepository destinationRepository;

    public List<Destination> findAll() {
        var all = destinationRepository.findAll();
        if (all.isEmpty()) {
            throw new ApiException("No Destination found");
        }
        return all;
    }

    public Destination findById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new ApiException("Destination not found"));
    }

    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }

    public void deleteById(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new ApiException("Destination not found");
        }
        destinationRepository.deleteById(id);
    }
}
