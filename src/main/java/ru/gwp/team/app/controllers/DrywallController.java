package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Drywall;
import ru.gwp.team.app.services.DrywallService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/drywall")
@Slf4j
public final class DrywallController {

    private final DrywallService drywallService;

    @Autowired
    DrywallController(DrywallService drywallService) {
        this.drywallService = drywallService;
    }

    @GetMapping
    public ResponseEntity<List<Drywall>> findAll() {
        return ResponseEntity.ok().body(drywallService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drywall> findById(@PathVariable String id) {
        return drywallService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Drywall> create(@RequestBody Drywall entity) {
        return drywallService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drywall> update(@PathVariable("id") String id, @RequestBody Drywall entity) {
        return drywallService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return drywallService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
