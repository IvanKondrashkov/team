package ru.gwp.team.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gwp.team.app.components.Color;
import ru.gwp.team.app.services.ColorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/color")
@Slf4j
public final class ColorController {

    private final ColorService colorService;

    @Autowired
    ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public ResponseEntity<List<Color>> findAll() {
        return ResponseEntity.ok().body(colorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> findById(@PathVariable String id) {
        return colorService.findById(UUID.fromString(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Color> create(@RequestBody Color entity) {
        return colorService.create(entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> update(@PathVariable("id") String id, @RequestBody Color entity) {
        return colorService.update(UUID.fromString(id), entity)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return colorService.deleteById(UUID.fromString(id))
                .map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }
}
