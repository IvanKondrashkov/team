package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Brick;
import ru.gwp.team.app.services.BrickService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brick")
@Slf4j
public final class BrickController {

    private final BrickService brickService;

    @Autowired
    BrickController(BrickService brickService) {
        this.brickService = brickService;
    }

    @GetMapping
    public ResponseEntity<List<Brick>> findAll() {
        return ResponseEntity.ok().body(brickService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brick> findById(@PathVariable String id) {
        return brickService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Brick> create(@RequestBody Brick entity) {
        return brickService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brick> create(@PathVariable("id") String id, @RequestBody Brick entity) {
        return brickService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> create(@PathVariable("id") String id) {
        return brickService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
