package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Plaster;
import ru.gwp.team.app.repos.PlasterRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class PlasterService extends BaseService {

    private final PlasterRepo plasterRepo;

    @Autowired
    PlasterService(PlasterRepo plasterRepo) {
        this.plasterRepo = plasterRepo;
    }

    public List<Plaster> findAll() {
        return plasterRepo.findAll();
    }

    public Optional<Plaster> findById(UUID id) {
        return plasterRepo.findById(id);
    }

    public Optional<Plaster> create(Plaster entity) {
        return Optional.of(plasterRepo.save(entity));
    }

    public Optional<Plaster> update(UUID id, Plaster entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setBondingBase(entity.getBondingBase());
                    record.setConsumption(entity.getConsumption());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    plasterRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}