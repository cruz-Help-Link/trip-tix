package org.dafe.tripTix.service;

import lombok.RequiredArgsConstructor;
import org.dafe.tripTix.entity.State;
import org.dafe.tripTix.entity.Terminal;
import org.dafe.tripTix.repository.StateRepository;
import org.dafe.tripTix.repository.TerminalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private TerminalRepository terminalRepository;
    private StateRepository stateRepository;

    public List<Terminal> findAll() {
        return terminalRepository.findAll();
    }

    public Terminal save(Terminal terminal) {
        State state = stateRepository.findById(terminal.getId())
                .orElseThrow(() -> new RuntimeException("State not found"));

        // Set the state for the terminal
        terminal.setState(state);


        return terminalRepository.save(terminal);
    }

    public void delete(Long id) {
        terminalRepository.deleteById(id);
    }
}

