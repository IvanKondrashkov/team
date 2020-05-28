package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Brick;
import ru.gwp.team.app.repos.BrickRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class BrickService extends BaseService {

    private final BrickRepo brickRepo;

    @Autowired
    BrickService(BrickRepo brickRepo) {
        this.brickRepo = brickRepo;
    }

    public List<Brick> findAll() {
        return brickRepo.findAll();
    }

    public Optional<Brick> findById(UUID id) {
        return brickRepo.findById(id);
    }

    public Optional<Brick> create(Brick entity) {
        return Optional.of(brickRepo.save(entity));
    }

    public Optional<Brick> update(UUID id, Brick entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setType(entity.getType());
                    record.setPalletQuantity(entity.getPalletQuantity());
                    record.setConsumption(entity.getConsumption());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    brickRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
