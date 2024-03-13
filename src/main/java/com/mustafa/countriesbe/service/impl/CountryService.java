package com.mustafa.countriesbe.service.impl;

import com.mustafa.countriesbe.dto.CountryDto;
import com.mustafa.countriesbe.entity.Country;
import com.mustafa.countriesbe.exception.AlreadyExistsException;
import com.mustafa.countriesbe.exception.CountryAlreadyExistsException;
import com.mustafa.countriesbe.exception.NotFoundException;
import com.mustafa.countriesbe.initializer.CountryInitializer;
import com.mustafa.countriesbe.mapper.ICountryMapper;
import com.mustafa.countriesbe.repository.CountryRepository;
import com.mustafa.countriesbe.service.interfaces.ICountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;
    private final ICountryMapper iCountryMapper;
    @Override
    public List<CountryDto> getAllCountry() {
        List<Country> countrys=  countryRepository.findAll();
        List<CountryDto> countryDtos = countrys.stream().
                map(country -> this.iCountryMapper.fromCountry(country)).collect(Collectors.toList());
        return countryDtos;
    }

    @Override
    public CountryDto getByIdCountry(Long id) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ülke bulunamadı."));
        return this.iCountryMapper.fromCountry(country);
    }

    @Override
    public CountryDto createCount(CountryDto countryDto) {
        Country existingCountry = countryRepository.findByCode(countryDto.getCode()).orElse(null);
        if(existingCountry != null){
            throw new AlreadyExistsException("Ülke bulunuyor");
        }
        Country country = this.iCountryMapper.toCountry(countryDto);
        this.countryRepository.save(country);
        return countryDto;
    }

    @Override
    public List<Country> insertCountry() {
        return countryRepository.saveAll(CountryInitializer.readCountries());
    }

    @Override
    public void delete(Long id) {
        this.countryRepository.deleteById(id);
    }
}
