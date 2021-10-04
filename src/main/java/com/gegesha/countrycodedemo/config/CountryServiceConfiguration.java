package com.gegesha.countrycodedemo.config;

import com.gegesha.countrycodedemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class CountryServiceConfiguration {

    private final CountryService countryService;

    @Autowired
    public CountryServiceConfiguration(CountryService countryService) {
        this.countryService = countryService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        countryService.initCountryList();
    }

}