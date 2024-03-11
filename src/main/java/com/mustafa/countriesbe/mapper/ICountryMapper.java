package com.mustafa.countriesbe.mapper;

import com.mustafa.countriesbe.dto.CountryDto;
import com.mustafa.countriesbe.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICountryMapper {
    Country toCountry(CountryDto countryDto);
    CountryDto fromCountry(Country country);
}
