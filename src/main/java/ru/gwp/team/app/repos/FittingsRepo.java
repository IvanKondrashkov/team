package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Fittings;

import java.util.UUID;

public interface FittingsRepo extends JpaRepository<Fittings, UUID> {
}
