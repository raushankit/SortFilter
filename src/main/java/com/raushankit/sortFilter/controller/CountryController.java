package com.raushankit.sortFilter.controller;

import com.raushankit.sortFilter.entity.Country;
import com.raushankit.sortFilter.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService service;

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(service.getAllCountries());
    }

}
