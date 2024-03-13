package com.mustafa.countriesbe.service.interfaces;

import com.mustafa.countriesbe.dto.CountryDto;
import com.mustafa.countriesbe.entity.Country;

import java.util.List;

public interface ICountryService {
    List<CountryDto> getAllCountry();
    CountryDto getByIdCountry(Long id);
    CountryDto createCount(CountryDto countryDto);
    List<Country> insertCountry();
    void delete(Long id);

}
