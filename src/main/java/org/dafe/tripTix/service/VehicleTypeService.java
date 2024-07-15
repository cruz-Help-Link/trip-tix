package org.dafe.tripTix.service;

import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.VehicleType;
import org.dafe.tripTix.repository.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType save(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public void delete(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}

