package com.example.beerstock.controller;

import com.example.beerstock.dto.request.BeerDTO;
import com.example.beerstock.exception.BeerAlreadyRegisteredException;
import com.example.beerstock.exception.BeerNotFoundException;
import com.example.beerstock.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {

    private final BeerService beerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO create(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return beerService.createBeer(beerDTO);
    }

    @GetMapping
    public List<BeerDTO> listAll() {
        return beerService.listAll();
    }

    @GetMapping("/{name}")
    public BeerDTO finByName(@PathVariable String name) throws BeerNotFoundException {
        return beerService.findByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {

        beerService.deleteById(id);
    }
}
