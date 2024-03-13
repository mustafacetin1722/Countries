package com.mustafa.countriesbe.controller;

import com.mustafa.countriesbe.dto.CountryDto;
import com.mustafa.countriesbe.entity.Country;
import com.mustafa.countriesbe.service.impl.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @GetMapping
    private List<CountryDto> getAll(){
        return this.countryService.getAllCountry();
    }
    @GetMapping("/{id}")
    public CountryDto getAllById(@PathVariable Long id){
        return this.countryService.getByIdCountry(id);
    }
    @PostMapping
    public CountryDto save(@RequestBody CountryDto countryDto){
        return this.countryService.createCount(countryDto);
    }
    @PostMapping("count")
    public List<Country> insertCountries(){
        return countryService.insertCountry();
    }

}
