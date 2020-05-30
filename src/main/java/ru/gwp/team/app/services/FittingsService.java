package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Fittings;
import ru.gwp.team.app.repos.FittingsRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class FittingsService extends BaseService {

    private final FittingsRepo fittingsRepo;

    @Autowired
    FittingsService(FittingsRepo fittingsRepo) {
        this.fittingsRepo = fittingsRepo;
    }

    public List<Fittings> findAll() {
        return fittingsRepo.findAll();
    }

    public Optional<Fittings> findById(UUID id) {
        return fittingsRepo.findById(id);
    }

    public Optional<Fittings> create(Fittings entity) {
        return Optional.of(fittingsRepo.save(entity));
    }

    public Optional<Fittings> update(UUID id, Fittings entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setSteelClass(entity.getSteelClass());
                    record.setSteelGrade(entity.getSteelGrade());
                    record.setProfileDiameter(entity.getProfileDiameter());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    fittingsRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}