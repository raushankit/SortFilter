package com.raushankit.sortFilter.repository;

import com.raushankit.sortFilter.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
