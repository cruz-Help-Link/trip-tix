package com.example.triptix.service;

import com.example.triptix.exception.ApiException;
import com.example.triptix.model.VehicleType;
import com.example.triptix.repo.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType findById(Long id) {
        return vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException("Vehicle type not found"));
    }

    public VehicleType save(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public void deleteById(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}

