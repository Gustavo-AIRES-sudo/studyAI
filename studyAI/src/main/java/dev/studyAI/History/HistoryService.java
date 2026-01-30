package dev.studyAI.History;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    public HistoryService(HistoryRepository historyRepository, HistoryMapper historyMapper) {
        this.historyRepository = historyRepository;
        this.historyMapper = historyMapper;
    }

    public HistoryDTO save(HistoryDTO historyDTO){
        HistoryModel history = historyMapper.map(historyDTO);
        history = historyRepository.save(history);
        return historyMapper.map(history);
    }

    public Set<HistoryDTO> all(){
        return historyRepository.findAll()
                .stream()
                .map(historyMapper::map)
                .collect(Collectors.toSet());
    }

    public HistoryDTO findHistory(Long id){
        Optional<HistoryModel> history = historyRepository.findById(id);
        return history.map(historyMapper::map)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public HistoryDTO alterHistory(HistoryDTO history, Long id){
        HistoryModel updatingHistory = historyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        historyMapper.updateHistoryFromDto(history, updatingHistory);
        return historyMapper.map(historyRepository.save(updatingHistory));
    }

    public void deleteHistory(Long id){
        if (historyRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        historyRepository.deleteById(id);
    }
}
