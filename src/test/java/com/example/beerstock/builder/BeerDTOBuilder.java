package com.example.beerstock.builder;


import com.example.beerstock.dto.request.BeerDTO;
import com.example.beerstock.enums.BeerType;



@lombok.Builder
public class BeerDTOBuilder {

    @lombok.Builder.Default
    private Long id = 1L;

    @lombok.Builder.Default
    private String name = "Brahma";

    @lombok.Builder.Default
    private String brand = "Ambev";

    @lombok.Builder.Default
    private Integer max = 50;

    @lombok.Builder.Default
    private Integer quantity = 10;

    @lombok.Builder.Default
    private BeerType type = BeerType.LAGER;

    public BeerDTO toBeerDTO(){
        return new BeerDTO(id,name,brand,max,quantity,type);
    }
}
