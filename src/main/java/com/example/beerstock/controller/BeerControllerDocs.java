package com.example.beerstock.controller;


import com.example.beerstock.dto.request.BeerDTO;
import com.example.beerstock.exception.BeerAlreadyRegisteredException;
import com.example.beerstock.exception.BeerNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api(value = "Manage beer stock")
public interface BeerControllerDocs {


    @ApiOperation(value = "Beer creation operation.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success beer creation."),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    BeerDTO create(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Returns list of all beers registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all beers registered in the system.")
    })
    public List<BeerDTO> listAll() ;

    @ApiOperation(value = "Return beer found by given name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success beer found in the system."),
            @ApiResponse(code = 404, message = "Beer with given name not found.")
    })
    public BeerDTO finByName(@PathVariable String name) throws BeerNotFoundException;

    @ApiOperation(value = "Delete a beer found by a given valid Id.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success beer deleted in the system."),
            @ApiResponse(code = 404, message = "Beer with given id not found.")
    })
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException;

}
