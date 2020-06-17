package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.ThermalInsulation;
import ru.gwp.team.app.repos.ThermalInsulationRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ThermalInsulationService extends BaseService {

    private final ThermalInsulationRepo thermalInsulationRepo;

    @Autowired
    ThermalInsulationService(ThermalInsulationRepo thermalInsulationRepo) {
        this.thermalInsulationRepo = thermalInsulationRepo;
    }

    public List<ThermalInsulation> findAll() {
        return thermalInsulationRepo.findAll();
    }

    public Optional<ThermalInsulation> findById(UUID id) {
        return thermalInsulationRepo.findById(id);
    }

    public Optional<ThermalInsulation> create(ThermalInsulation entity) {
        return Optional.of(thermalInsulationRepo.save(entity));
    }

    public Optional<ThermalInsulation> update(UUID id, ThermalInsulation entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setStrength(entity.getPurpose());
                    record.setMaterial(entity.getMaterial());
                    record.setType(entity.getType());
                    record.setStrength(entity.getStrength());
                    record.setNumberPerPack(entity.getNumberPerPack());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    thermalInsulationRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
