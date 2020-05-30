package ru.gwp.team.app.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gwp.team.app.components.ThermalInsulation;

import java.util.UUID;
public interface ThermalInsulationRepo extends JpaRepository<ThermalInsulation, UUID>{
}
