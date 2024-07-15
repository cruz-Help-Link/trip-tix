package org.dafe.tripTix.service;

import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.TransportRoute;
import org.dafe.tripTix.repository.TransportRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportRouteService {
    private TransportRouteRepository transportRouteRepository;

    public List<TransportRoute> findAll() {
        return transportRouteRepository.findAll();
    }

    public TransportRoute save(TransportRoute transportRoute) {
        return transportRouteRepository.save(transportRoute);
    }

    public void delete(Long id) {
        transportRouteRepository.deleteById(id);
    }
}

