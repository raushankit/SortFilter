package com.raushankit.sortFilter.service;

import com.raushankit.sortFilter.entity.Country;
import com.raushankit.sortFilter.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private CountryRepository repository;

    public List<Country> getAllCountries() {
        return (List<Country>) repository.findAll();
    }

    public void save(List<Country> countries) {
        repository.saveAll(countries);
    }
}
