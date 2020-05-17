package ru.gwp.team.app._example.components;

import lombok.*;
import ru.gwp.team.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public final class ExampleEntity extends BaseEntity {

    @NotNull
    @NotEmpty
    @Size(max = 128)
    @Column(length = 128)
    private String title;

    @NotNull
    @Size(max = 512)
    @Column(length = 512)
    private String description;

}
