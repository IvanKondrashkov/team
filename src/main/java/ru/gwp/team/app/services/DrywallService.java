package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Drywall;
import ru.gwp.team.app.repos.DrywallRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class DrywallService extends BaseService {

    private final DrywallRepo drywallRepo;

    @Autowired
    DrywallService(DrywallRepo drywallRepo) {
        this.drywallRepo = drywallRepo;
    }

    public List<Drywall> findAll() {
        return drywallRepo.findAll();
    }

    public Optional<Drywall> findById(UUID id) {
        return drywallRepo.findById(id);
    }

    public Optional<Drywall> create(Drywall entity) {
        return Optional.of(drywallRepo.save(entity));
    }

    public Optional<Drywall> update(UUID id, Drywall entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setMoistureResistance(entity.getMoistureResistance());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    drywallRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
