package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Drywall;

import java.util.UUID;

public interface DrywallRepo extends JpaRepository<Drywall, UUID> {
}
