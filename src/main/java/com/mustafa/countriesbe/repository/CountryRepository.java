package com.mustafa.countriesbe.repository;

import com.mustafa.countriesbe.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
