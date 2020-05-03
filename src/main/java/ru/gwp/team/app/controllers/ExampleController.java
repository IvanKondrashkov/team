package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.ExampleEntity;
import ru.gwp.team.app.services.ExampleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/example")
@Slf4j
public final class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping
    public ResponseEntity<List<ExampleEntity>> findAll() {
        return ResponseEntity.ok().body(exampleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleEntity> findById(@PathVariable String id) {
        return exampleService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExampleEntity> create(@RequestBody ExampleEntity entity) {
        return exampleService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExampleEntity> create(@PathVariable("id") String id, @RequestBody ExampleEntity entity) {
        return exampleService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> create(@PathVariable("id") String id) {
        return exampleService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
