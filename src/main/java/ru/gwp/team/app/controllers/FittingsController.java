package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Fittings;
import ru.gwp.team.app.services.FittingsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fittings")
@Slf4j
public final class FittingsController {

    private final FittingsService fittingsService;

    @Autowired
    FittingsController(FittingsService fittingsService) {
        this.fittingsService = fittingsService;
    }

    @GetMapping
    public ResponseEntity<List<Fittings>> findAll() {
        return ResponseEntity.ok().body(fittingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fittings> findById(@PathVariable String id) {
        return fittingsService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fittings> create(@RequestBody Fittings entity) {
        return fittingsService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fittings> update(@PathVariable("id") String id, @RequestBody Fittings entity) {
        return fittingsService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return fittingsService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
