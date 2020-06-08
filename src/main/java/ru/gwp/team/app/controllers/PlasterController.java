package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Plaster;
import ru.gwp.team.app.services.PlasterService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/plaster")
@Slf4j
public final class PlasterController {

    private final PlasterService plasterService;

    @Autowired
    PlasterController(PlasterService plasterService) {
        this.plasterService = plasterService;
    }

    @GetMapping
    public ResponseEntity<List<Plaster>> findAll() {
        return ResponseEntity.ok().body(plasterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plaster> findById(@PathVariable String id) {
        return plasterService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Plaster> create(@RequestBody Plaster entity) {
        return plasterService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plaster> update(@PathVariable("id") String id, @RequestBody Plaster entity) {
        return plasterService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return plasterService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}