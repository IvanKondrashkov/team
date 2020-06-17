package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Profile;
import java.util.UUID;

public interface ProfileRepo extends JpaRepository<Profile, UUID> {
}
