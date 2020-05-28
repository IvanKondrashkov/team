package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Color;
import ru.gwp.team.app.repos.ColorRepo;
import ru.gwp.team.core.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ColorService extends BaseService {

    private final ColorRepo colorRepo;

    @Autowired
    ColorService(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }

    public List<Color> findAll() {
        return colorRepo.findAll();
    }

    public Optional<Color> findById(UUID id) {
        return colorRepo.findById(id);
    }

    public Optional<Color> create(Color entity) {
        return Optional.of(colorRepo.save(entity));
    }

    public Optional<Color> update(UUID id, Color entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setColor(entity.getColor());
                    record.setPurpose(entity.getPurpose());
                    record.setGlossDegree(entity.getGlossDegree());
                    record.setCapacity(entity.getCapacity());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    colorRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}

