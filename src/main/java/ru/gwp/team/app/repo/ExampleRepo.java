package ru.gwp.team.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.ExampleEntity;

import java.util.UUID;

public interface ExampleRepo extends JpaRepository<ExampleEntity, UUID> {
}
