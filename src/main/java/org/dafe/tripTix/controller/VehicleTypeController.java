package org.dafe.tripTix.controller;

import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.VehicleType;
import org.dafe.tripTix.service.VehicleTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeService.findAll();
    }

    @PostMapping
    public VehicleType createVehicleType(@RequestBody VehicleType vehicleType) {
        return vehicleTypeService.save(vehicleType);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.delete(id);
    }
}
