package com.lapin.web4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Point {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Min(-5)
    @Max(3)
    private Double x;
    @NotNull
    @Min(-3)
    @Max(3)
    private Double y;
    @NotNull
    @Min(-5)
    @Max(3)
    private Double r;
    @NotNull
    private Boolean hitResult;
    @NotNull
    private OffsetDateTime time;
    @NotNull
    private BigDecimal executionTime;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
