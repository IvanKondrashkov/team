package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Plaster;

import java.util.UUID;

public interface PlasterRepo extends JpaRepository<Plaster, UUID> {
}