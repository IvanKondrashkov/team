package ru.gwp.team.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gwp.team.app.components.Profile;
import ru.gwp.team.app.repos.ProfileRepo;
import ru.gwp.team.core.BaseService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ProfileService extends BaseService {

    private final ProfileRepo profileRepo;

    @Autowired
    ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    public Optional<Profile> findById(UUID id) {
        return profileRepo.findById(id);
    }

    public Optional<Profile> create(Profile entity) {
        return Optional.of(profileRepo.save(entity));
    }

    public Optional<Profile> update(UUID id, Profile entity) {
        return findById(id)
                .map(record -> {
                    setBaseFeatures(record, entity);
                    record.setMaterial(entity.getMaterial());
                    record.setType(entity.getType());
                    return create(record);
                })
                .orElse(Optional.empty());
    }

    public Optional<Boolean> deleteById(UUID id) {
        return findById(id)
                .map(record -> {
                    profileRepo.deleteById(id);
                    return Optional.of(Boolean.TRUE);
                })
                .orElse(Optional.empty());
    }
}
