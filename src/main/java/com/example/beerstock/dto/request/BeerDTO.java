package com.example.beerstock.dto.request;

import com.example.beerstock.enums.BeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {

    private Long id;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String name;

    @NotEmpty
    @Size(min = 1,max = 200)
    private String brand;

    @NotEmpty
    @Max(500)
    private Integer max;

    @NotEmpty
    @Max(100)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private BeerType type;
}
