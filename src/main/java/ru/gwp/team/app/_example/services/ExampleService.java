package ru.gwp.team.app._example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app._example.components.ExampleEntity;
import ru.gwp.team.app._example.repos.ExampleRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ExampleService {

    private final ExampleRepo exampleRepo;

    @Autowired
    ExampleService(ExampleRepo exampleRepo) {
        this.exampleRepo = exampleRepo;
    }

    public List<ExampleEntity> findAll() {
        return exampleRepo.findAll();
    }

    public Optional<ExampleEntity> findById(UUID id) {
        return exampleRepo.findById(id);
    }

    public Optional<ExampleEntity> create(ExampleEntity entity) {
        return Optional.of(exampleRepo.save(entity));
    }

    public Optional<ExampleEntity> update(UUID id, ExampleEntity entity) {
        return findById(id)
                .map(record -> {
                    record.setTitle(entity.getTitle());
                    record.setDescription(entity.getDescription());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    exampleRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
