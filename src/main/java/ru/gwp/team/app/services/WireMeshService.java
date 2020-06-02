package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.WireMesh;
import ru.gwp.team.app.repos.WireMeshRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class WireMeshService extends BaseService {

    private final WireMeshRepo wireMeshRepo;

    @Autowired
    WireMeshService(WireMeshRepo wireMeshRepo) {
        this.wireMeshRepo = wireMeshRepo;
    }

    public List<WireMesh> findAll() {
        return wireMeshRepo.findAll();
    }

    public Optional<WireMesh> findById(UUID id) {
        return wireMeshRepo.findById(id);
    }

    public Optional<WireMesh> create(WireMesh entity) {
        return Optional.of(wireMeshRepo.save(entity));
    }

    public Optional<WireMesh> update(UUID id, WireMesh entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setMaterial(entity.getMaterial());
                    record.setSquareSize(entity.getSquareSize());
                    record.setRodDiameter(entity.getRodDiameter());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    wireMeshRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
