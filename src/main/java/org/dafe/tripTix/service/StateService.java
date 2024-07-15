package org.dafe.tripTix.service;

import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.State;
import org.dafe.tripTix.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State save(State state) {
        return stateRepository.save(state);
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}

