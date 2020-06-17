package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.ThermalInsulation;
import ru.gwp.team.app.services.ThermalInsulationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/thermalInsulation")
@Slf4j
public final class ThermalInsulationController {

    private final ThermalInsulationService thermalInsulationService;

    @Autowired
    ThermalInsulationController(ThermalInsulationService thermalInsulationService) {
        this.thermalInsulationService = thermalInsulationService;
    }

    @GetMapping
    public ResponseEntity<List<ThermalInsulation>> findAll() {
        return ResponseEntity.ok().body(thermalInsulationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThermalInsulation> findById(@PathVariable String id) {
        return thermalInsulationService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ThermalInsulation> create(@RequestBody ThermalInsulation entity) {
        return thermalInsulationService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThermalInsulation> update(@PathVariable("id") String id, @RequestBody ThermalInsulation entity) {
        return thermalInsulationService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return thermalInsulationService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
