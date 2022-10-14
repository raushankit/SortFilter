package com.raushankit.sortFilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raushankit.sortFilter.entity.Country;
import com.raushankit.sortFilter.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SortFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SortFilterApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CountryService service) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/countries.json");
			try {
				List<Country> countries = mapper.readValue(inputStream,typeReference);
				service.save(countries);
				System.out.println("Countries Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
