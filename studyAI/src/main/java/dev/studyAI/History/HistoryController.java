package dev.studyAI.History;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/history")
@RestController
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<HistoryDTO> historyCreating(@RequestBody HistoryDTO historyDTO){
        HistoryDTO savedHistory = historyService.save(historyDTO);
        return ResponseEntity.ok(savedHistory);//200
    }

    //READ
    @GetMapping("/all")
    public ResponseEntity<Set<HistoryDTO>> historyAll(){
        Set<HistoryDTO> histories = historyService.all();
        return ResponseEntity.ok(histories);//200
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HistoryDTO> findHistoryById(@PathVariable Long id){
        HistoryDTO history = historyService.findHistory(id);
        return ResponseEntity.ok(history);//200
    }

    //UPDATE
    @PatchMapping("/alter/{id}")
    public ResponseEntity<HistoryDTO> alterHistory(@PathVariable Long id, @RequestBody HistoryDTO historyDTO){
        HistoryDTO updatedHistory = historyService.alterHistory(historyDTO, id);
        return ResponseEntity.ok(updatedHistory);//200
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHistory (@PathVariable Long id){
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}