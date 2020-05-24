package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.Brick;

import java.util.UUID;

public interface BrickRepo extends JpaRepository<Brick, UUID> {
}
