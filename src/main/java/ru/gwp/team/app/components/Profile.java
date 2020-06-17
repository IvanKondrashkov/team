package ru.gwp.team.app.components;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Profile extends BaseMaterial {

    @NotNull
    @NotEmpty


    @Size(max = 32)
    @Column(length = 32)
    private String material;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String type;
}
