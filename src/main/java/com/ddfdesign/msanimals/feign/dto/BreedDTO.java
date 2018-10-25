package com.ddfdesign.msanimals.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreedDTO {
    private Long id;
    private String name;
    private Double junior_price;
    private Double adult_price;
    private Long specy;
}
