package ru.gwp.team.app._example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app._example.components.ExampleEntity;

import java.util.UUID;

public interface ExampleRepo extends JpaRepository<ExampleEntity, UUID> {
}
