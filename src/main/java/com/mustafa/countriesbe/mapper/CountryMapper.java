package com.mustafa.countriesbe.mapper;

import com.mustafa.countriesbe.dto.CountryDto;
import com.mustafa.countriesbe.entity.Country;

public class CountryMapper {
    // nesne oluşturularak çevirme
    public Country fromCountryDto(CountryDto countryDto){
        return Country.builder()
                .code(countryDto.getCode())
                .name(countryDto.getName())
                .flag(countryDto.getFlag())
                .phone(countryDto.getPhone())
                .capital(countryDto.getCapital())
                .continent(countryDto.getContinent())
                .currency(countryDto.getCurrency())
                .nativeName(countryDto.getNativeName())
                .language(countryDto.getLanguage())
                .build();
    }
    public CountryDto fromCountryDto(Country country){
        return CountryDto.builder()
                .id(country.getId())
                .code(country.getCode())
                .name(country.getName())
                .flag(country.getFlag())
                .phone(country.getPhone())
                .capital(country.getCapital())
                .continent(country.getContinent())
                .currency(country.getCurrency())
                .nativeName(country.getNativeName())
                .language(country.getLanguage())
                .build();
    }
}
