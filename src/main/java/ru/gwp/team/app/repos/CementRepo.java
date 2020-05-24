package ru.gwp.team.app.repos;

        import org.springframework.data.jpa.repository.JpaRepository;
        import ru.gwp.team.app.components.Cement;

        import java.util.UUID;

public interface CementRepo extends JpaRepository<Cement, UUID> {
}
