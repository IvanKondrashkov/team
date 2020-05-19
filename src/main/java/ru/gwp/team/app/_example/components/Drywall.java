package ru.gwp.team.app._example.components;

import lombok.*;
import ru.gwp.team.app.components.BaseMaterial;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Drywall extends BaseMaterial {

    @NotNull
    private Boolean moistureResistance;

}
