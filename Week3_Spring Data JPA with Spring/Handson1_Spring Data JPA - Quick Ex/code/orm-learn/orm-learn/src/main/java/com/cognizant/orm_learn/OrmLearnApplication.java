package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		testFindCountryByCode();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("End");
	}

	private static void testFindCountryByCode() throws Exception {
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Found: {}", country);
	}

	private static void testAddCountry() throws Exception {
		Country newCountry = new Country();
		newCountry.setCode("ZZ");
		newCountry.setName("TestLand");
		countryService.addCountry(newCountry);
		LOGGER.debug("Added: {}", countryService.findCountryByCode("ZZ"));
	}

	private static void testUpdateCountry() throws Exception {
		countryService.updateCountry("ZZ", "UpdatedLand");
		LOGGER.debug("Updated: {}", countryService.findCountryByCode("ZZ"));
	}

	private static void testDeleteCountry() throws Exception {
		countryService.deleteCountry("ZZ");
		LOGGER.debug("Deleted ZZ country");
	}
}
