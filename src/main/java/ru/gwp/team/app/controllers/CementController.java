package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Cement;
import ru.gwp.team.app.services.CementService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cement")
@Slf4j
public final class CementController {

    private final CementService cementService;

    @Autowired
    CementController(CementService cementService) {
        this.cementService = cementService;
    }

    @GetMapping
    public ResponseEntity<List<Cement>> findAll() {
        return ResponseEntity.ok().body(cementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cement> findById(@PathVariable String id) {
        return cementService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cement> create(@RequestBody Cement entity) {
        return cementService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cement> update(@PathVariable("id") String id, @RequestBody Cement entity) {
        return cementService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return cementService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}

