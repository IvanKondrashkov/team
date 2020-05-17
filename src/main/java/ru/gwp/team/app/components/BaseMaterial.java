package ru.gwp.team.app.components;

import lombok.*;
import ru.gwp.team.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class BaseMaterial extends BaseEntity {

    @NotNull
    @NotEmpty
    @Size(max = 128)
    @Column(length = 128)
    private String name;

    @NotNull
    @Size(max = 1024)
    @Column(length = 1024)
    private String description;

    @NotNull
    @Size(max = 32)
    @Column(length = 32)
    private String unit;

    @NotNull
    private Double price;

    private Double weight;

    private Double height;

    private Double width;

    private Double length;

    @NotNull
    @Size(max = 256)
    @Column(length = 256)
    private String manufacturer;

    private Date issueDate;

    private Date expirationDate;
}
