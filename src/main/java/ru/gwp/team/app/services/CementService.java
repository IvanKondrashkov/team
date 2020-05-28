package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Cement;
import ru.gwp.team.app.repos.CementRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class CementService extends BaseService {

    private final CementRepo cementRepo;

    @Autowired
    CementService(CementRepo cementRepo) {
        this.cementRepo = cementRepo;
    }

    public List<Cement> findAll() {
        return cementRepo.findAll();
    }

    public Optional<Cement> findById(UUID id) {
        return cementRepo.findById(id);
    }

    public Optional<Cement> create(Cement entity) {
        return Optional.of(cementRepo.save(entity));
    }

    public Optional<Cement> update(UUID id, Cement entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setLabel(entity.getLabel());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    cementRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}

