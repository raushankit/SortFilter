package com.raushankit.sortFilter.controller;

import com.raushankit.sortFilter.dto.CountryDto;
import com.raushankit.sortFilter.entity.Country;
import com.raushankit.sortFilter.entity.CountryName;
import com.raushankit.sortFilter.repo.TypedClass;
import com.raushankit.sortFilter.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager em;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.ok(
                service.getAllCountries()
                        .stream()
                        .map(this::convert)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/cq")
    public void testCq() {
        TypedClass<Country> tp = new TypedClass<>(em, Country.class);
        tp.test();
    }

    private CountryDto convert(Country country) {
        CountryDto data = modelMapper.map(country, CountryDto.class);
        CountryName name = country.getName();
        if(name != null) {
            data.setCommonName(name.getCommonName());
            data.setOfficialName(name.getOfficialName());
        }
        return data;
    }

}
