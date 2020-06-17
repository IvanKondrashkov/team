package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Color;

import java.util.UUID;

public interface ColorRepo extends JpaRepository<Color, UUID> {
}
