package com.mustafa.countriesbe.repository;

import com.mustafa.countriesbe.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findByCode(String code);
}
