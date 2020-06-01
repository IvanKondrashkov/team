package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.WireMesh;
import ru.gwp.team.app.services.WireMeshService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wireMesh")
@Slf4j
public final class WireMeshController {

    private final WireMeshService wireMeshService;

    @Autowired
    WireMeshController(WireMeshService wireMeshService) {
        this.wireMeshService = wireMeshService;
    }

    @GetMapping
    public ResponseEntity<List<WireMesh>> findAll() {
        return ResponseEntity.ok().body(wireMeshService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WireMesh> findById(@PathVariable String id) {
        return wireMeshService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WireMesh> create(@RequestBody WireMesh entity) {
        return wireMeshService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WireMesh> create(@PathVariable("id") String id, @RequestBody WireMesh entity) {
        return wireMeshService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> create(@PathVariable("id") String id) {
        return wireMeshService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
