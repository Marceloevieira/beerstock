package com.example.beerstock.service;

import com.example.beerstock.dto.request.BeerDTO;
import com.example.beerstock.entity.Beer;
import com.example.beerstock.exception.BearAlreadyRegisteredException;
import com.example.beerstock.exception.BeerNotFoundException;
import com.example.beerstock.mapper.BeerMapper;
import com.example.beerstock.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {


    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;


    public BeerDTO createBeer(BeerDTO beerDTO) throws BearAlreadyRegisteredException {

        verifyIfIsAlreadyRegistered(beerDTO.getName());

        var beerToSave = beerMapper.toModel(beerDTO);
        var beerToSaved = beerRepository.save(beerToSave);

        return beerMapper.toDTO(beerToSaved);
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException {

        Beer foundBeer = beerRepository.findByName(name)
                .orElseThrow(() -> new BeerNotFoundException(name));

        return beerMapper.toDTO(foundBeer);
    }

    public List<BeerDTO> listAll() {

        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }


    public void deleteById(Long id) throws BeerNotFoundException {

        verifyIfExistId(id);
        beerRepository.deleteById(id);
    }

    private void verifyIfExistId(Long id) throws BeerNotFoundException {

        beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));

    }

    private void verifyIfIsAlreadyRegistered(String name) throws BearAlreadyRegisteredException {

        Optional<Beer> foundBeer = beerRepository.findByName(name);

        if (foundBeer.isPresent()) {
            throw new BearAlreadyRegisteredException(name);
        }

    }

}
