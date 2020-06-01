package ru.gwp.team.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.WireMesh;

import java.util.UUID;

public interface WireMeshRepo extends JpaRepository<WireMesh, UUID> {
}
